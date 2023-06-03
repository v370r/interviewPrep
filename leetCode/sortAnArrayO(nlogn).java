package leetCode;

import java.util.Arrays;

class sortAnArray {
    public static void main(String[] args) {
        int arr[] = { 50, 12, 11, 13, 5, 6, 7 };
        // mergeSort(arr, 0, arr.length - 1);
        // System.out.println("Sorted arr is : " + Arrays.toString(arr));

        mergesort(arr, 0, arr.length - 1);
        System.out.println("Sorted arr is : " + Arrays.toString(arr));
    }

    private static void mergesort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid + 1);
            mergeSort(arr, mid, r);
            Merge(arr, l, mid, r);
        }
    }

    // ------------------------------------------------------------

    private static void Merge(int[] arr, int l, int mid, int r) {
        int leftlen = mid - l + 1;
        int rightlen = r - mid;
        int[] leftarr = new int[leftlen];
        int[] rightarr = new int[rightlen];
        for (int i = 0; i < leftlen; i++) {
            leftarr[i] = arr[i];
        }
        for (int i = 0; i < rightlen; i++) {
            rightarr[i] = arr[mid + i + 1];
        }

        int i = 0, j = 0, k = l;
        while ((i < leftlen) && (j < rightlen)) {
            if (leftarr[i] < rightarr[j]) {
                arr[k] = leftarr[i];
                i++;
            } else {
                arr[k] = rightarr[j];
                j++;
            }
            k++;
        }
        while (i < leftlen) {
            arr[k] = leftarr[i];
            i++;
            k++;
        }

        while (j < rightlen) {
            arr[k] = rightarr[j];
            k++;
            j++;
        }
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
