package arrays.Sorting_Searching.sorting;

import java.util.Arrays;

public class heapSort {
    int[] arr = null;

    heapSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        BinaryHeap bh = new BinaryHeap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            bh.insertinHeap(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = bh.extractHeadofHeap();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 9, 3, 1, 2, 8, 4, 7, 6 };
        heapSort hs = new heapSort(arr);
        hs.sort();
        System.out.println(Arrays.toString(arr));
    }
}
