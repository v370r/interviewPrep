package udemyDSA.arrays;

public class diagonalSumofArray {
    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(diagonalSum(a));
    }

    private static int diagonalSum(int[][] a) {
        int m = a.length, n = a[0].length, sum = 0;
        if (m != n) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            sum += a[i][i];
        }
        return sum;
    }
}
