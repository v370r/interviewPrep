package DynamicProgramming.geeksForGeeksTop20;

public class minCostPath {
    public static void main(String[] args) {
        int cost[][] = { { 1, 2, 3 },
                { 4, 8, 2 },
                { 1, 5, 3 } };
        // System.out.println("Min cost path :" + recPathSum(cost));
        System.out.println("Min SUm path dp : " + dpSum(cost));
    }

    private static int dpSum(int[][] cost) {
        int m = 2;
        int n = 2;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = cost[0][0];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + cost[i][0];
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] + cost[0][i];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = cost[i][j] + min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[m][n];

    }

    private static int recPathSum(int[][] cost) {
        int m = cost.length;
        int n = cost[0].length;
        return minCostPath(cost, m - 1, n - 1);
    }

    // If diagonal is also allowed
    private static int minCostPath(int[][] cost, int m, int n) {
        if (m == 0 && n == 0) {
            return cost[0][0];
        }
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        return cost[m][n]
                + min(minCostPath(cost, m - 1, n), minCostPath(cost, m, n - 1), minCostPath(cost, m - 1, n - 1));
    }

    private static int min(int a, int b, int c) {
        if (a < c && a < b) {
            return a;
        } else if (b < c && b < a) {
            return b;
        } else {
            return c;
        }
    }
}
