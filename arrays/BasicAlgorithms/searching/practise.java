package arrays.BasicAlgorithms.searching;

import java.util.Arrays;

public class practise {
    public static void main(String[] args) {
        int a[] = { 1, 3, 5, 6, 7, 8 };
        System.out.println(Arrays.stream(a));
        System.out.println(binarysearchTesta(a));
    }

    private static int binarysearchTesta(int[] a) {
        int target = 1;
        int last = a.length - 1;
        int first = 0;
        int mid = 0;
        while (first < last) {
            mid = (first + last) / 2;
            if (a[mid] < target) {
                first = mid;
            } else if (a[mid] > target) {
                last = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
