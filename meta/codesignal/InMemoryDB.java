package interviewPrep.meta.codesignal;
import java.util.*;

public class InMemoryDB {
    private static final long NO_EXPIRE = Long.MAX_VALUE;
    private final Map<String, TreeMap<String, Entry>> db = new HashMap<>();
    private final PriorityQueue<Expiry> expiryQ = new PriorityQueue<>(Comparator.comparingLong(e -> e.expiresAt));
    private long nextVersion = 1;
    private final TreeMap<Integer, Snapshot> backups = new TreeMap<>();
    private int lastTime = Integer.MIN_VALUE;

    // ======================
    // Level 1 (no timestamp)
    // ======================
    public void set(String key, String field, String value) {
        // Non-timestamp mode: no TTL, no expirations; just store.
        TreeMap<String, Entry> rec = db.computeIfAbsent(key, k -> new TreeMap<>());
        rec.put(field, new Entry(value, NO_EXPIRE, nextVersion++));
    }

    public String get(String key, String field) {
        TreeMap<String, Entry> rec = db.get(key);
        if (rec == null)
            return "";
        Entry e = rec.get(field);
        return e == null ? "" : e.value;
    }

    public boolean delete(String key, String field) {
        TreeMap<String, Entry> rec = db.get(key);
        if (rec == null)
            return false;
        Entry removed = rec.remove(field);
        if (rec.isEmpty())
            db.remove(key);
        return removed != null;
    }

    // ======================
    // Level 2 (no timestamp)
    // ======================
    public List<String> scan(String key) {
        TreeMap<String, Entry> rec = db.get(key);
        if (rec == null)
            return Collections.emptyList();

        List<String> out = new ArrayList<>(rec.size());
        for (Map.Entry<String, Entry> it : rec.entrySet()) {
            out.add(it.getKey() + "(" + it.getValue().value + ")");
        }
        return out;
    }

    public List<String> scanByPrefix(String key, String prefix) {
        TreeMap<String, Entry> rec = db.get(key);
        if (rec == null)
            return Collections.emptyList();

        List<String> out = new ArrayList<>();
        // TreeMap lets us iterate in sorted order; we still filter by prefix.
        for (Map.Entry<String, Entry> it : rec.entrySet()) {
            if (it.getKey().startsWith(prefix)) {
                out.add(it.getKey() + "(" + it.getValue().value + ")");
            }
        }
        return out;
    }

    // ======================
    // Level 3 (timestamped + TTL)
    // ======================
    public void setAt(String key, String field, String value, int timestamp) {
        advanceTime(timestamp);
        TreeMap<String, Entry> rec = db.computeIfAbsent(key, k -> new TreeMap<>());
        rec.put(field, new Entry(value, NO_EXPIRE, nextVersion++));
    }

    public void setAtWithTtl(String key, String field, String value, int timestamp, int ttl) {
        advanceTime(timestamp);
        long expiresAt = (long) timestamp + (long) ttl; // valid in [timestamp, timestamp+ttl)
        TreeMap<String, Entry> rec = db.computeIfAbsent(key, k -> new TreeMap<>());
        long ver = nextVersion++;
        rec.put(field, new Entry(value, expiresAt, ver));
        expiryQ.add(new Expiry(expiresAt, key, field, ver));
    }

    public String getAt(String key, String field, int timestamp) {
        advanceTime(timestamp);
        TreeMap<String, Entry> rec = db.get(key);
        if (rec == null)
            return "";
        Entry e = rec.get(field);
        return e == null ? "" : e.value;
    }

    public boolean deleteAt(String key, String field, int timestamp) {
        advanceTime(timestamp);
        TreeMap<String, Entry> rec = db.get(key);
        if (rec == null)
            return false;

        Entry removed = rec.remove(field);
        if (rec.isEmpty())
            db.remove(key);
        return removed != null;
    }

    public List<String> scanAt(String key, int timestamp) {
        advanceTime(timestamp);
        return scan(key);
    }

    public List<String> scanByPrefixAt(String key, String prefix, int timestamp) {
        advanceTime(timestamp);
        return scanByPrefix(key, prefix);
    }

    // ======================
    // Level 4 (backup/restore)
    // ======================
    public void backup(int timestamp) {
        advanceTime(timestamp);
        Snapshot snap = new Snapshot();
        for (Map.Entry<String, TreeMap<String, Entry>> recIt : db.entrySet()) {
            String key = recIt.getKey();
            TreeMap<String, Entry> rec = recIt.getValue();

            TreeMap<String, SnapEntry> recSnap = new TreeMap<>();
            for (Map.Entry<String, Entry> fIt : rec.entrySet()) {
                String field = fIt.getKey();
                Entry e = fIt.getValue();

                long remaining;
                if (e.expiresAt == NO_EXPIRE) {
                    remaining = -1;
                } else {
                    remaining = e.expiresAt - (long) timestamp; // remaining TTL at backup time
                    if (remaining <= 0) {
                        // Should not happen because advanceTime(timestamp) purged expired,
                        // but keep it safe.
                        continue;
                    }
                }
                recSnap.put(field, new SnapEntry(e.value, remaining));
            }
            if (!recSnap.isEmpty()) {
                snap.data.put(key, recSnap);
            }
        }
        backups.put(timestamp, snap);
    }

    public void restore(int now, int timestampToRestore) {
        advanceTime(now);

        Map.Entry<Integer, Snapshot> floor = backups.floorEntry(timestampToRestore);

        // Clear current DB + expiration queue
        db.clear();
        expiryQ.clear();
        nextVersion = 1; // reset versions cleanly after restore

        if (floor == null) {
            // No backup available <= timestampToRestore => empty DB
            return;
        }

        Snapshot snap = floor.getValue();

        // Rebuild DB and expirations based on "remaining TTL" stored in snapshot
        for (Map.Entry<String, TreeMap<String, SnapEntry>> recIt : snap.data.entrySet()) {
            String key = recIt.getKey();
            TreeMap<String, SnapEntry> recSnap = recIt.getValue();

            TreeMap<String, Entry> rec = new TreeMap<>();
            for (Map.Entry<String, SnapEntry> fIt : recSnap.entrySet()) {
                String field = fIt.getKey();
                SnapEntry se = fIt.getValue();

                long ver = nextVersion++;
                long expiresAt = NO_EXPIRE;

                if (se.remainingTtl >= 0) {
                    expiresAt = (long) now + se.remainingTtl;
                    expiryQ.add(new Expiry(expiresAt, key, field, ver));
                }

                rec.put(field, new Entry(se.value, expiresAt, ver));
            }

            if (!rec.isEmpty()) {
                db.put(key, rec);
            }
        }
    }

    // ======================
    // Internals
    // ======================

    private void advanceTime(int timestamp) {
        // Timestamped tests guarantee non-decreasing time.
        if (timestamp < lastTime) {
            // If this ever happens, safest behavior is still to purge at current timestamp.
            // But under OA constraints, it shouldn't.
        }
        lastTime = timestamp;

        long now = timestamp;

        // Purge expired fields using the min-heap.
        while (!expiryQ.isEmpty() && expiryQ.peek().expiresAt <= now) {
            Expiry ex = expiryQ.poll();
            TreeMap<String, Entry> rec = db.get(ex.key);
            if (rec == null)
                continue;

            Entry cur = rec.get(ex.field);
            if (cur == null)
                continue;

            // Only delete if this expiry corresponds to the current value/version.
            if (cur.version == ex.version && cur.expiresAt == ex.expiresAt) {
                rec.remove(ex.field);
                if (rec.isEmpty())
                    db.remove(ex.key);
            }
        }
    }

    private static class Entry {
        final String value;
        final long expiresAt; // NO_EXPIRE if no ttl
        final long version;

        Entry(String value, long expiresAt, long version) {
            this.value = value;
            this.expiresAt = expiresAt;
            this.version = version;
        }
    }

    private static class Expiry {
        final long expiresAt;
        final String key;
        final String field;
        final long version;

        Expiry(long expiresAt, String key, String field, long version) {
            this.expiresAt = expiresAt;
            this.key = key;
            this.field = field;
            this.version = version;
        }
    }

    private static class Snapshot {
        // key -> (field -> snapshot entry), sorted by field
        final Map<String, TreeMap<String, SnapEntry>> data = new HashMap<>();
    }

    private static class SnapEntry {
        final String value;
        // -1 => no ttl; otherwise remaining ttl at backup time (>0)
        final long remainingTtl;

        SnapEntry(String value, long remainingTtl) {
            this.value = value;
            this.remainingTtl = remainingTtl;
        }
    }
}