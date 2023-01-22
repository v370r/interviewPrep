package arrays.geeksForGeeksTop20;

import java.util.Arrays;

/*
 * Merge two sorted Arrays
 */
public class mergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 4, 6, 8, 9, 100 };
        int[] arr2 = { 3, 5, 6, 7 };
        // mergeTwoSortedArraysWithNoExtraSpace(arr1, arr2);
        mergeTwoSortedArraysWithExtraSpace(arr1, arr2);
    }

    private static void mergeTwoSortedArraysWithExtraSpace(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int finalLength = arr1.length + arr2.length;
        int[] res = new int[finalLength];
        while (k < finalLength && j < arr2.length && i < arr1.length) {
            if (arr1[i] < arr2[j] && i < arr1.length) {
                res[k] = arr1[i];
                i++;
                k++;
            } else if (arr1[i] >= arr2[j] && j < arr2.length) {
                res[k] = arr2[j];
                j++;
                k++;
            }
        }
        if (i == arr1.length) {
            while (j < arr2.length) {
                res[k] = arr2[j];
                j++;
                k++;
            }
        } else {
            while (i < arr1.length) {
                res[k] = arr1[i];
                i++;
                k++;
            }
        }
        System.out.println(Arrays.toString(res));
    }

    // TODO: have to do with No extra space O(1)
    private static void mergeTwoSortedArraysWithNoExtraSpace(int[] arr1, int[] arr2) {

    }
}
