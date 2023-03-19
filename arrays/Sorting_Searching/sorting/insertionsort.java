package arrays.Sorting_Searching.sorting;

import java.util.Arrays;

public class insertionsort {
    public static void main(String[] args) {
        int[] arr = { 5, 9, 3, 1, 2, 8, 4, 7, 6 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
     * Divide array into sorted and unsorted two parts
     * - take first element from unsorted arrayh and find its correct position in
     * sorted array
     * - repeat until its unsorted is empty
     */
    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i], j = i;

            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
