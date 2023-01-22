package arrays.geeksForGeeksTop20;

import java.util.Arrays;

/*
 * Given a sorted array of positive integers. 
 * Your task is to rearrange the array elements alternatively i.e first element should be max value, 
 * second should be min value, third should be second max, fourth should be second min and so on.
 * //TODO:  Modify the original array itself. Do it without using any extra space. You do not have to return anything.
 */
public class rearrangeSortedArrayAlternatively {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        System.out.println(Arrays.toString(rearrangeSolution(arr)));
        // System.out.println(rearrangeNoSpaceSolution(arr));

    }

    // TODO:
    // private static int[] rearrangeNoSpaceSolution(int[] arr) {
    // int len = arr.length;
    // int curr_max_ind;
    // int curr_min_ind;
    // int final_ind = 0;
    // int temp_val = arr[curr_min_ind];
    // while (final_ind < len) {
    // arr[final_ind] = arr[curr_max_ind];
    // curr_max_ind--;
    // final_ind++;
    // temp_val = arr[curr_min_ind + 1];
    // arr[final_ind] = arr[curr_min_ind];
    // curr_min_ind++;

    // }
    // return arr;
    // }

    private static int[] rearrangeSolution(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int k = 0;
        int arr2[] = new int[j + 1];
        while (k < arr.length) {
            if (k % 2 == 1) {
                arr2[k] = arr[j];
                j--;
                k++;
            } else {
                arr2[k] = arr[i];
                i++;
                k++;
            }
        }
        return arr2;
    }
}
