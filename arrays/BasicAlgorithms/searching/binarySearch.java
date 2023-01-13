package arrays.BasicAlgorithms.searching;

import java.util.Arrays;

/*
 * search a sorted array with order of Log(n) and return index
 */
public class binarySearch {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 3, 5, 9, 12 };
        int target = 3;
        System.out.println(Arrays.binarySearch(arr, target)); // default method
        System.out.println(binarySearchSolution(arr, target));
    }

    private static int binarySearchSolution(int[] arr, int target) {
        int len = arr.length;
        int first = 0;
        int last = len;
        int mid;
        while (first <= last) {
            mid = (first + last) / 2;
            if (arr[mid] < target) {
                first = mid + 1; // if the target is last element
            } else if (arr[mid] > target) {
                last = mid - 1; // reduce so it can reach 0 (element not present) and first >last
            } else {
                return mid;
            }
        }

        return 0;

    }
}
