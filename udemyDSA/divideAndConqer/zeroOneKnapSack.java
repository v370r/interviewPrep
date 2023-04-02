package udemyDSA.divideAndConqer;

/*
 * https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
 * 
 * You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 *  Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively.
Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item,
either pick the complete item or dont pick it (0-1 property)

N = 3
W = 4
values[] = {1,2,3}
weight[] = {4,5,1}
Output: 3
 */
public class zeroOneKnapSack {
    public static void main(String[] args) {
        int values[] = { 1, 2, 3 },
                weight[] = { 4, 5, 1 }, capacity = 4;
        System.out
                .println("Maximum weight we can have  using recursion " + recursiveSolution(values, weight, capacity));
        System.out.println("Using DP " + dpSolution(values, weight, capacity));
    }

    private static int dpSolution(int[] values, int[] weight, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < capacity + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i - 1]] + values[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacity];
    }

    private static int recursiveSolution(int[] values, int[] weight, int capacity) {
        int index = 0;
        return recursiveSolution(values, weight, capacity, index);
    }

    private static int recursiveSolution(int[] values, int[] weight, int capacity, int index) {
        if (index >= values.length) {
            return 0;
        }
        if (weight[index] <= capacity) {
            return Math.max(values[index] + recursiveSolution(values, weight, capacity - weight[index], index + 1),
                    recursiveSolution(values, weight, capacity, index + 1));
        }
        return recursiveSolution(values, weight, capacity, index + 1);
    }

}
