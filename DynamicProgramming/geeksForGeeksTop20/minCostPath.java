package DynamicProgramming.geeksForGeeksTop20;

public class minCostPath {
    public static void main(String[] args) {
        int cost[][] = { { 3, 8, 6, 0, 5, 9, 9, 6, 3, 4, 0, 5, 7, 3, 9, 3 },
                { 0, 9, 2, 5, 5, 4, 9, 1, 4, 6, 9, 5, 6, 7, 3, 2 }, { 8, 2, 2, 3, 3, 3, 1, 6,
                        9, 1, 1, 6, 6, 2, 1, 9 },
                { 1, 3, 6, 9, 9, 5, 0, 3, 4, 9, 1, 0, 9, 6, 2, 7 }, { 8, 6, 2, 2, 1, 3, 0, 0,
                        7, 2, 7, 5, 4, 8, 4, 8 },
                { 4, 1, 9, 5, 8, 9, 9, 2, 0, 2, 5, 1, 8, 7, 0, 9 }, { 6, 2, 1, 7, 8, 1, 8, 5,
                        5, 7, 0, 2, 5, 7, 2, 1 },
                { 8, 1, 7, 6, 2, 8, 1, 2, 2, 6, 4, 0, 5, 4, 1, 3 }, { 9, 2, 1, 7, 6, 1, 4, 3,
                        8, 6, 5, 5, 3, 9, 7, 3 },
                { 0, 6, 0, 2, 4, 3, 7, 6, 1, 3, 8, 6, 9, 0, 0, 8 }, { 4, 3, 7, 2, 4, 3, 6, 4,
                        0, 3, 9, 5, 3, 6, 9, 3 },
                { 2, 1, 8, 8, 4, 5, 6, 5, 8, 7, 3, 7, 7, 5, 8, 3 }, { 0, 7, 6, 6, 1, 2, 0, 3,
                        5, 0, 8, 0, 8, 7, 4, 3 },
                { 0, 4, 3, 4, 9, 0, 1, 9, 7, 7, 8, 6, 4, 6, 9, 5 }, { 6, 5, 1, 9, 9, 2, 2, 7,
                        4, 2, 7, 2, 2, 3, 7, 2 },
                { 7, 1, 9, 6, 1, 2, 7, 0, 9, 6, 6, 4, 4, 5, 1, 0 }, { 3, 4, 9, 2, 8, 3, 1, 2,
                        6, 9, 7, 0, 2, 4, 2, 0 },
                { 5, 1, 8, 8, 4, 6, 8, 5, 2, 4, 1, 6, 2, 2, 9, 7 } };
        // int cost[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println("Min cost path :" + recPathSum(cost));
        // System.out.println("Min SUm path dp : " + dpSum(cost));
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
        int m = cost.length - 1;
        int n = cost[0].length - 1, curr_Sum = 0;
        // return minCostPath(cost, m - 1, n - 1);
        return helper1(cost, m, n, curr_Sum);
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

    private static int helper(int[][] cost, int m, int n, int curr_Sum) {
        if (m == 0 && n == 0) {
            return cost[0][0];
        } else if (m == 0) {
            return cost[0][n] + helper(cost, 0, n - 1, curr_Sum);
        } else if (n == 0) {
            return cost[m][0] + helper(cost, m - 1, 0, curr_Sum);
        }
        return cost[m][n] + Math.min(helper(cost, m, n - 1, curr_Sum),
                helper(cost, m - 1, n, curr_Sum));
    }

    private static int helper1(int[][] cost, int m, int n, int curr_Sum) {
        if (m == 0 && n == 0) {
            return cost[0][0] + curr_Sum;
        } else if (m == 0) {
            return helper1(cost, 0, n - 1, cost[0][n] + curr_Sum);
        } else if (n == 0) {
            return helper1(cost, m - 1, 0, cost[m][0] + curr_Sum);
        } else if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        return Math.min(helper1(cost, m, n - 1, cost[m][n] + curr_Sum),
                helper1(cost, m - 1, n, cost[m][n] + curr_Sum));
    }

}
