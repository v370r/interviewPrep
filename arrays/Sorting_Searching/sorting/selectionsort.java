package arrays.Sorting_Searching.sorting;

import java.util.Arrays;

/*
 * Find the minimum elemtne and move it to the sorted part of arrya to make unsorted part sorted
 */
public class selectionsort {
    public static void main(String[] args) {
        int[] arr = { 5, 9, 3, 1, 2, 8, 4, 7, 6 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
     * Insertion sort: pick the minimum index and swap them
     */
    private static void sort(int[] arr) {
        int len = arr.length;
        for (int j = 0; j < len; j++) {
            int minimumIndex = j;
            for (int i = j + 1; i < len; i++) {
                if (arr[i] < arr[minimumIndex]) {
                    minimumIndex = i;
                }
            }
            // If its in correct location no need to swap or else swap
            if (minimumIndex != j) {
                int temp = arr[j];
                arr[j] = arr[minimumIndex];
                arr[minimumIndex] = temp;
            }
        }
    }

}
