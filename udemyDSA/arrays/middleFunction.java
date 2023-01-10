package udemyDSA.arrays;

import java.util.Arrays;

/*
 * write a function that returns arrays except first 
 * ****and last element 
 */
public class middleFunction {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 7 };
        int len = a.length;
        System.out.println(Arrays.toString(Arrays.copyOfRange(a, 1, len - 1))); // best
        System.out.println(Arrays.toString(solve_brute(a, len)));
        System.out.println(Arrays.binarySearch(null, null, null));
    }

    private static int[] solve_brute(int[] a, int len) {
        int b[] = new int[len - 2];
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0 || i == len - 1) {
                continue;
            } else {
                b[j] = a[i];
                j += 1;
            }
        }
        return b;
    }

}
