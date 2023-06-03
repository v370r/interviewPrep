package arrays.geeksForGeeksTop20;

import java.util.Arrays;

/*
 * Given a sorted array of positive integers. 
 * Your task is to rearrange the array elements alternatively i.e first element should be max value, 
 * second should be min value, third should be second max, fourth should be second min and so on.
 *  Modify the original array itself. Do it without using any extra space. You do not have to return anything.
 */
public class rearrangeSortedArrayAlternatively {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        // System.out.println(Arrays.toString(rearrangeSolution(arr)));
        rearrangeNoSpaceSolution(arr);
        System.out.println(Arrays.toString(arr));

    }

    /*
     * even location :- arr[i] = arr[i]+ (arr[max_indx]%me)*me
     * odd location :- arr[i] = arr[i]+ (arr[min_indx]%me)*me
     */
    private static void rearrangeNoSpaceSolution(int[] arr) {
        int len = arr.length;
        int max_element = arr[len - 1] + 1;
        boolean flag = true;
        int front = 0;
        int back = len - 1;
        for (int i = 0; i < len; i++) {
            if (flag) {
                int val = arr[back] % max_element;
                arr[i] += max_element * val;
                back--;
            } else {
                int val = arr[front] % max_element;
                arr[i] += max_element * val;
                front++;
            }
            flag = !flag;
        }
        for (int i = 0; i < len; i++) {
            arr[i] /= max_element;
        }
    }

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
