package udemyDSA.divideAndConqer;

import java.util.Arrays;

/*
 * 
 * given cost find the no of unique paths
 */
public class noOfUniqueWaysGivenCost {
    public static void main(String[] args) {
        int grid[][] = { { 4, 7, 1, 6 },
                { 5, 7, 3, 9 },
                { 3, 2, 1, 2 },
                { 7, 1, 6, 3 } }, cost = 25;
        System.out.println(
                "No of unique ways with given cost " + cost + " Using recursion " + recursionSolution(grid, cost));
        System.out.println("DP solution : " + dpSolution(grid, cost));
        System.out.println("GPT solution : " + dpSolutionByGPT(grid, cost));
    }
    // gpt solution

    public static int dpSolutionByGPT(int[][] grid, int cost) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n - 1][m - 1] <= cost ? countPaths(dp, n, m, cost) : 0;
    }

    public static int countPaths(int[][] dp, int n, int m, int cost) {
        int[][] count = new int[n][m];
        count[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (dp[i][0] <= cost) {
                count[i][0] = 1;
            }
        }
        for (int j = 1; j < m; j++) {
            if (dp[0][j] <= cost) {
                count[0][j] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] <= cost) {
                    count[i][j] = count[i - 1][j] + count[i][j - 1];
                }
            }
        }
        return count[n - 1][m - 1];
    }

    // --------------------------------------------------------------------------------------------------------------

    // FIXME:
    private static String dpSolution(int[][] grid, int cost) {
        int m = grid.length, n = grid[0].length;
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 0;
            dp[i][1] = grid[i - 1][0] + dp[i - 1][1];
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 0;
            dp[1][i] = grid[0][i - 1] + dp[1][i - 1];
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = grid[i - 1][j - 1] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        for (int i = 0; i <= m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println("Now count paths that leads to the given cost");
        return null;
    }

    private static int recursionSolution(int[][] grid, int cost) {
        int indexRow = 0, indexCol = 0;
        return recursiveHelper(grid, indexCol, indexRow, cost);
    }

    private static int recursiveHelper(int[][] grid, int indexCol, int indexRow, int cost) {
        if (cost < 0) {
            return 0;
        }
        if (indexCol == grid.length - 1 && indexRow == grid[0].length - 1) {
            if (cost == grid[indexCol][indexRow]) {
                return 1;
            } else {
                return 0;
            }
        } else if (cost < grid[indexCol][indexRow]) {
            return 0;
        } else if (indexCol == grid.length - 1 && cost > 0) {
            return recursiveHelper(grid, indexCol, indexRow + 1, cost - grid[indexCol][indexRow]);
        } else if (indexRow == grid[0].length - 1 && cost > 0) {
            return recursiveHelper(grid, indexCol + 1, indexRow, cost - grid[indexCol][indexRow]);
        } else {
            return recursiveHelper(grid, indexCol, indexRow + 1, cost - grid[indexCol][indexRow])
                    + recursiveHelper(grid, indexCol + 1, indexRow, cost - grid[indexCol][indexRow]);
        }
    }
}
