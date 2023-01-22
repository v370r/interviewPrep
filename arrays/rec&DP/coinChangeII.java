/**
 * Unlimited coins different denominations
 * return total number of combinations
 * infinite number of each coins
 * 
 * if j>=coins[i-1]
 * *****dp[i][j-coins[i-1]] + dp[i-1][j]
 * else
 * *****dp[i-1][j]
 */

public class coinChangeII {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 5;
        System.out.println(solveWithRecursion(coins, amount));
        System.out.println(solveWithDynamicProgramming(coins, amount));
    }

    private static int solveWithRecursion(int[] coins, int amount) {
        int index = 0;
        return solveWithRecursion(coins, amount, index);

    }

    private static int solveWithDynamicProgramming(int[] coins, int amount) {
        return 0;
    }

    private static int solveWithRecursion(int[] coins, int amount, int index) {
        if (amount < 0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        int count = 0;
        for (int i = index; i < coins.length; i++) {
            count += solveWithRecursion(coins, amount - coins[i], i);

        }
        return count;
    };
}