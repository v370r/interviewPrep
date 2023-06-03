package arrays.Sorting_Searching;

import java.util.Arrays;

/*
 * Binary search O(logn)
 */
public class binarySearch {
    static int a[] = { 1, 2, 3, 4, 7 };

    public static void main(String[] args) {
        int key = 3;
        int start = 0, end = a.length - 1;
        System.out.println(Arrays.binarySearch(a, key));
        System.out.println(binarySearchSolution(a, key, start, end));
    }

    // TODO: implement BinarySearch
    private static int binarySearchSolution(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return start;
    }
}
