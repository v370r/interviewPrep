import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] a, int[] b) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            mp.put(a[i], 1);
        }
        for (int i = 0; i < b.length; i++) {
            if (mp.get(b[i]) != null && mp.get(b[i]) == 1) {
                mp.put(b[i], 0);
            } else if (mp.get(b[i]) == null || mp.get(b[i]) != 0) {
                mp.put(b[i], 2);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() == 1) {
                res1.add(entry.getKey());
            } else if (entry.getValue() == 2)
                res2.add(entry.getKey());
        }
        res.add(res1);
        res.add(res2);
        return res;
    }
}