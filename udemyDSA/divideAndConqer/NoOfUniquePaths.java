package udemyDSA.divideAndConqer;

/*
 * https://leetcode.com/problems/unique-paths/
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class NoOfUniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println("No of unique Paths : " + uniquePathsinRecursion(m, n));
        System.out.println("DP solution for no of ways : " + dpSolution(m, n));
    }

    private static int dpSolution(int m, int n) {
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
            dp[1][i] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }

    private static int uniquePathsinRecursion(int m, int n) {
        int currColumn = 0, currRow = 0;
        return recursiveHelper(m, currColumn, n, currRow);
    }

    private static int recursiveHelper(int m, int currColumn, int n, int currRow) {
        if (currColumn == m - 1 && currRow == n - 1) {
            return 1;
        } else if (currColumn == m - 1) {
            return recursiveHelper(m, currColumn, n, currRow + 1);
        } else if (currRow == n - 1) {
            return recursiveHelper(m, currColumn + 1, n, currRow);
        } else {
            return recursiveHelper(m, currColumn + 1, n, currRow) + recursiveHelper(m, currColumn, n, currRow + 1);
        }
    }
}
