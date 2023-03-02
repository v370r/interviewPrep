
package arrays.geeksForGeeksTop20;

import java.util.HashMap;
import java.util.Map;

/**
 * slidingWindowCountDistinct
 */
public class slidingWindowCountDistinct {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 3, 4, 2, 3 }, K = 4;
        // Function call
        countDistinct(arr, K);
    }

    private static void countDistinct(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < k; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(mp.size());
        for (int i = k; i < arr.length; i++) {
            if (mp.get(arr[i - k]) == 1) {
                mp.remove(arr[i - k]);
            } else {
                mp.put(arr[i - k], mp.get(arr[i - k]) - 1);
            }
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
            System.out.println(mp.size());
        }

    }
}