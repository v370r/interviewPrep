package udemyDSA.arrays;

import java.util.Arrays;

/*
 * Rotate a matrix by 90` 
 * Algorithm {
 ***  for i = 0 to n:
 *******temp = top[i]
 *******top[i] = left[i]
 *******left[i] = bottom[i]
 *******bottom[i] = right[i]
 *******right[i] = temp
 * }
 */
public class matrixRotation {
    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Arrays.deepToString(rotateMatrix(a)));

    }

    // TODO: didnt understand much may need to write to picture
    private static int[][] rotateMatrix(int[][] a) {
        if (a.length == 0 || a.length != a[0].length) {
            return a;
        }
        int n = a.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = a[first][i];
                a[first][i] = a[last - offset][first];
                a[last - offset][first] = a[last][last - offset];
                a[last][last - offset] = a[i][last];
                a[i][last] = top;

            }

        }
        return a;

    }
}
