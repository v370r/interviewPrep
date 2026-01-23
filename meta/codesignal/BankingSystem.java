package interviewPrep.meta.codesignal;
import java.util.*;
import java.util.stream.Collectors;

public class BankingSystem {
    private Map<String, InstantAmount> balance;
    long paymentId = 0;
    Map<String, ArrayDeque<Long>> pendingIdsByKey = new HashMap<>();
    Set<Long> cancelledIds = new HashSet<>();
    Queue<ScheduledPayment> scheduledPayments = new PriorityQueue<>(
            (a, b) -> {
                int cmp = Integer.compare(a.executeAt, b.executeAt);
                if (cmp != 0)
                    return cmp;
                return Long.compare(a.id, b.id);
            });

    public BankingSystem() {
        balance = new HashMap<>();
    }

    // Level 1
    public boolean createAccount(String accountId, int timestamp) {
        if (balance.containsKey(accountId))
            return false;
        balance.put(accountId, new InstantAmount(0, timestamp));
        return true;
    }

    // Level 1
    public boolean deposit(String accountId, int timestamp, int amount) {
        InstantAmount acc = balance.get(accountId);
        if (acc == null)
            return false;

        acc.value += amount;
        acc.timestamp = timestamp;
        return true;
    }

    public int getBalance(String accountId, int timestamp) {
        InstantAmount acc = balance.get(accountId);
        return acc == null ? -1 : acc.value;
    }

    public boolean transfer(String fromAccountId, String toAccountId, int timestamp, int amount) {
        InstantAmount from = balance.get(fromAccountId);
        InstantAmount to = balance.get(toAccountId);
        if (from == null || to == null)
            return false;
        if (from.value < amount)
            return false;
        from.value -= amount;
        from.spent += amount;
        from.timestamp = timestamp;
        to.value += amount;
        to.timestamp = timestamp;
        return true;
    }

    public List<String> topSpenders(int timestamp, int n) {
        List<String> ids = balance.entrySet().stream()
                .sorted((a, b) -> {
                    int cmp = Integer.compare(b.getValue().spent, a.getValue().spent); // spent desc
                    if (cmp != 0)
                        return cmp;
                    return a.getKey().compareTo(b.getKey()); // tie: id asc
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int k = Math.min(n, ids.size());
        return ids.subList(0, k);
    }

    public boolean schedulePayment(String fromAccountId, int timestamp, int amount, int executeAt) {
        if (!balance.containsKey(fromAccountId))
            return false;
        long id = paymentId++;
        ScheduledPayment p = new ScheduledPayment(fromAccountId, executeAt, amount, id);
        scheduledPayments.add(p);
        String key = key(fromAccountId, executeAt);
        pendingIdsByKey.computeIfAbsent(key, k -> new ArrayDeque<>()).addLast(id);
        return true;

    }

    public boolean cancelPayment(String fromAccountId, int timestamp, int executeAt) {
        String key = key(fromAccountId, executeAt);
        ArrayDeque<Long> dq = pendingIdsByKey.get(key);
        if (dq == null)
            return false;
        while (!dq.isEmpty() && cancelledIds.contains(dq.peekFirst())) {
            dq.pollFirst();
        }
        if (dq.isEmpty())
            return false;
        long id = dq.pollFirst();
        cancelledIds.add(id);
        if (dq.isEmpty())
            pendingIdsByKey.remove(key);
        return true;
    }

    public void processPayments(int timestamp) {
        while (!scheduledPayments.isEmpty() && scheduledPayments.peek().executeAt <= timestamp) {
            ScheduledPayment p = scheduledPayments.poll();
            if (cancelledIds.contains(p.id)) {
                removePendingIfPresent(p.account, p.executeAt, p.id);
                continue;
            }
            removePendingIfPresent(p.account, p.executeAt, p.id);
            InstantAmount acc = balance.get(p.account);
            if (acc == null)
                continue;
            if (acc.value >= p.amount) {
                acc.value -= p.amount;
                acc.spent += p.amount;
            }
        }
    }

    private void removePendingIfPresent(String account, int executeAt, long id) {
        String key = key(account, executeAt);
        ArrayDeque<Long> q = pendingIdsByKey.get(key);
        if (q == null)
            return;
        if (!q.isEmpty() && q.peekFirst() == id) {
            q.pollFirst();
        } else {
            while (!q.isEmpty() && cancelledIds.contains(q.peekFirst())) {
                q.pollFirst();
            }
            if (!q.isEmpty() && q.peekFirst() == id) {
                q.pollFirst();
            }
        }
        if (q.isEmpty())
            pendingIdsByKey.remove(key);
    }

    public String key(String acc, int executeAt) {
        return acc + "#" + executeAt;
    }

    // Helper class
    class InstantAmount {
        int value;
        int spent;
        int timestamp;

        InstantAmount(int value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
            this.spent = 0;
        }
    }

    class ScheduledPayment {
        String account;
        int executeAt;
        int amount;
        long id;

        public ScheduledPayment(String account, int executeAt, int amount, long id) {
            this.account = account;
            this.executeAt = executeAt;
            this.amount = amount;
            this.id = id;
        }

    }
}
