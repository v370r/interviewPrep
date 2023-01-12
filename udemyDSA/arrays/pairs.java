package udemyDSA.arrays;

import java.util.HashMap;
import java.util.Map;

public class pairs {
    public static void main(String[] args) {
        int[] a = { 2, 4, 3, 5, 6, -2, 4, 7, 8, 9 };
        int target = 7;
        System.out.println(pairSolution(a, target));
    }

    private static String pairSolution(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        String ret = "";
        for (int i = 0; i < a.length; i++) {
            if (map.get(target - a[i]) != null) {
                ret += a[i] + ":" + (target - a[i]) + " ";
            } else {
                map.put(a[i], i);
            }
        }

        return ret;
    }
}
