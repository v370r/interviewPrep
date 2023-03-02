package leetCode;

import java.util.Arrays;

class sortAnArray {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted arr is : " + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int leftLength = m - l + 1;
        int rightLength = r - m;
        int[] left = new int[leftLength];
        int[] right = new int[rightLength];

        for (int i = 0; i < leftLength; i++) {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = arr[m + j + 1];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < leftLength && j < rightLength) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < leftLength) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            arr[k] = right[j];
            k++;
            j++;
        }

    }

}
