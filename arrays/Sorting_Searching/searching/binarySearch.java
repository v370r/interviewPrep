package arrays.Sorting_Searching.searching;

import java.lang.annotation.Target;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 5, 6, 22, 45, 234 };
        int target = 234;
        binarySearch(arr, target);
    }

    private static void binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                System.out.println("found at index : " + mid);
                return;
            }
        }
        System.out.println("Not found " + left);
    }
}
