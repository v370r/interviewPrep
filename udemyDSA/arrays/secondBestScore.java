package udemyDSA.arrays;

import java.util.Arrays;
/*
 * order of n return first two biggest numbers from given list
 */

public class secondBestScore {
    public static void main(String[] args) {
        int[] a = { 84, 85, 86, 87, 85, 90, 85, 83, 23, 45, 84, 1, 2, 0 };
        System.out.println(Arrays.toString(secondBest(a)));
    }

    private static Integer[] secondBest(int[] a) {
        // Step 1: Convert TreeSet to ArrayList or
        // LinkedList
        Integer[] res = new Integer[2];
        int global_Max = Integer.MIN_VALUE, secondHigh = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (global_Max < a[i]) {
                global_Max = a[i];
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (secondHigh < a[i] && secondHigh < global_Max && a[i] != global_Max) {
                secondHigh = a[i];
            }
        }
        res[0] = global_Max;
        res[1] = secondHigh;
        return res;

    }
}
