package udemyDSA.arrays;

import java.util.Arrays;

public class secondBestScore {
    public static void main(String[] args) {
        int[] a = { 84, 85, 86, 87, 85, 90, 85, 83, 23, 45, 84, 1, 2, 0 };
        System.out.println(Arrays.toString(secondBest(a)));
        System.out.println(solution(a));
    }

    private static Integer[] secondBest(int[] a) {
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

    private static String solution(int[] a) {
        int[] arr = a;
        Arrays.sort(arr);
        int first = arr[a.length - 1];
        int second = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] != first) {
                second = arr[i];
                break;
            }
        }
        return first + " " + second;

    }
}
