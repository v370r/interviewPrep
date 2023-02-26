package DynamicProgramming;

class paintersPartition {
    public static void main(String[] args) {
        int[] arr = new int[] { 10, 20, 60, 50, 30, 40 };
        int n = arr.length;
        int k = 3; // 3 painters
        // System.out.println("Solving using recursion : " + recSolution(arr, n, k));
        System.out.println("Solve using dp : " + dpSolution(arr, n, k));
    }

    private static int dpSolution(int[] arr, int n, int k) {
        int dp[][] = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[1][i] = sum(arr, 0, i);
        }
        for (int i = 1; i <= k; i++) {
            dp[i][1] = arr[0];
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                int best = Integer.MAX_VALUE;
                for (int l = 0; l <= j; l++) {
                    best = Math.min(best, Math.max(dp[i - 1][l], sum(arr, l, j)));
                }

                dp[i][j] = best;

            }
        }
        return dp[k][n];
    }

    /*
     * T(n,k) = min{max{T(i,k-1)ΣA_j }} && (T(1,k) = arr[0] && T(n,1) = Σaarr[i])
     * Best = int_max;
     * best = min(best,max(partition(arr,i,k-1),sum(arr,i,n)))
     */
    private static int recSolution(int[] arr, int n, int k) {

        if (k == 1) {
            return sum(arr, 0, n);
        }
        if (n == 1) {
            return arr[0];
        }
        int best = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            best = Math.min(best, Math.max(recSolution(arr, i, k - 1), sum(arr, i, n)));
        }
        return best;

    }

    private static int sum(int[] arr, int from, int to) {
        int total = 0;
        for (int j = from; j < to; j++) {
            total += arr[j];
        }
        return total;
    }

}