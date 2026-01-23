package interviewPrep.meta.codesignal;
import java.util.*;
import java.util.stream.Collectors;

public class CloudFileStorage {

    private final Map<String, Integer> files = new TreeMap<>();

    private final Map<String, String> ownerByPath = new HashMap<>();     // path -> userId
    private final Map<String, Integer> capacityByUser = new HashMap<>(); // userId -> total
    private final Map<String, Integer> usedByUser = new HashMap<>();     // userId -> used
    private final Map<String, Set<String>> pathsByUser = new HashMap<>();// userId -> set of paths

    // Level 4 backups: userId -> snapshot(path -> size)
    private final Map<String, Map<String, Integer>> backupByUser = new HashMap<>();

    // ===== Level 1 =====
    public boolean addFile(String path, int size) {
        if (files.containsKey(path)) return false;
        files.put(path, size);
        return true;
    }

    public int getFileSize(String path) {
        return files.getOrDefault(path, -1);
    }

    public boolean deleteFile(String path) {
        Integer removedSize = files.remove(path);
        if (removedSize == null) return false;

        String owner = ownerByPath.remove(path);
        if (owner != null) {
            usedByUser.put(owner, usedByUser.get(owner) - removedSize);
            pathsByUser.getOrDefault(owner, Set.of()).remove(path);
        }
        return true;
    }

    // ===== Level 2 =====
    public List<String> getLargestFiles(String prefix, int n) {
        if (n <= 0) return List.of();

        return files.entrySet().stream()
                .filter(e -> e.getKey().startsWith(prefix))
                .sorted((a, b) -> {
                    int cmp = Integer.compare(b.getValue(), a.getValue()); // size desc
                    if (cmp != 0) return cmp;
                    return a.getKey().compareTo(b.getKey());               // path asc
                })
                .limit(n)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
    }

    // ===== Level 3 =====
    public boolean addUser(String userId, int capacity) {
        if (capacityByUser.containsKey(userId)) return false;
        capacityByUser.put(userId, capacity);
        usedByUser.put(userId, 0);
        pathsByUser.put(userId, new HashSet<>());
        return true;
    }

    // returns remaining capacity, or -1
    public int addFileByUser(String userId, String path, int size) {
        if (!capacityByUser.containsKey(userId)) return -1;
        if (files.containsKey(path)) return -1;

        int used = usedByUser.get(userId);
        int cap = capacityByUser.get(userId);
        if (used + size > cap) return -1;

        files.put(path, size);
        ownerByPath.put(path, userId);
        usedByUser.put(userId, used + size);
        pathsByUser.get(userId).add(path);

        return cap - (used + size);
    }

    // merge userB into userA; return remaining capacity of userA, or -1
    public int mergeUser(String userA, String userB) {
        if (!capacityByUser.containsKey(userA) || !capacityByUser.containsKey(userB)) return -1;
        if (userA.equals(userB)) return -1;

        int newCap = capacityByUser.get(userA) + capacityByUser.get(userB);
        int usedA = usedByUser.get(userA);
        int usedB = usedByUser.get(userB);

        // Move ownership of B's files to A
        Set<String> bPaths = pathsByUser.getOrDefault(userB, Set.of());
        for (String p : bPaths) ownerByPath.put(p, userA);
        pathsByUser.get(userA).addAll(bPaths);

        capacityByUser.put(userA, newCap);
        usedByUser.put(userA, usedA + usedB);

        // remove B
        capacityByUser.remove(userB);
        usedByUser.remove(userB);
        pathsByUser.remove(userB);

        // drop B backup
        backupByUser.remove(userB);

        return newCap - (usedA + usedB);
    }

    // ===== Level 4 =====

    // snapshot user's current owned files; return count, or -1
    public int backupUser(String userId) {
        if (!capacityByUser.containsKey(userId)) return -1;

        Map<String, Integer> snap = new TreeMap<>(); // keep snapshot sorted (optional)
        for (String path : pathsByUser.getOrDefault(userId, Set.of())) {
            Integer size = files.get(path);
            if (size != null) snap.put(path, size);
        }

        backupByUser.put(userId, snap);
        return snap.size();
    }

    // restore from latest backup; return restored count, or -1
    public int restoreUser(String userId) {
        if (!capacityByUser.containsKey(userId)) return -1;

        Map<String, Integer> snap = backupByUser.get(userId);
        if (snap == null) return 0;

        // 1) delete all current files owned by user
        Set<String> current = new HashSet<>(pathsByUser.getOrDefault(userId, Set.of()));
        for (String path : current) deleteFile(path);

        // 2) restore from snapshot (skip conflicts + capacity overflow)
        int restored = 0;
        int cap = capacityByUser.get(userId);
        int used = usedByUser.getOrDefault(userId, 0);

        for (Map.Entry<String, Integer> e : snap.entrySet()) {
            String path = e.getKey();
            int size = e.getValue();

            if (files.containsKey(path)) continue;       // conflict with other user
            if (used + size > cap) continue;             // quota

            files.put(path, size);
            ownerByPath.put(path, userId);
            pathsByUser.get(userId).add(path);

            used += size;
            restored++;
        }

        usedByUser.put(userId, used);
        return restored;
    }
}
