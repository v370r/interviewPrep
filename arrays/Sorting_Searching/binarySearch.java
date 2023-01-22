package arrays.Sorting_Searching;

import java.util.Arrays;

/*
 * Binary search O(logn)
 */
public class binarySearch {
    static int a[] = { 1, 2, 3, 4, 7 };

    public static void main(String[] args) {
        int key = 3;
        System.out.println(Arrays.binarySearch(a, key));
        System.out.println(binarySearchSolution(a, key));
    }

    // TODO: implement BinarySearch
    private static int binarySearchSolution(int[] a2, int key) {
        return (Integer) null;
    }
}
