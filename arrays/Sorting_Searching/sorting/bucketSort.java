package arrays.Sorting_Searching.sorting;

import java.util.*;

public class bucketSort {
    public static void main(String[] args) {
        int[] arr = { 5, 9, 3, 1, 2, 8, 4, 7, 6 };
        bucketsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bucketsort(int[] arr) {
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int maxValue = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int value : arr) {
            int bucketNumber = (int) Math.ceil((float) value * numberOfBuckets / ((float) maxValue));
            buckets[bucketNumber - 1].add(value);
        }

        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int value : bucket) {
                arr[index] = value;
                index++;
            }
        }
    }
}
