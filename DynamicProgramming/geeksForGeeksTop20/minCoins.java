package DynamicProgramming.geeksForGeeksTop20;

public class minCoins {
    public static void main(String[] args) {
        int coins[] = { 9, 6, 5, 1 };
        int m = coins.length;
        int target = 11;

        System.out.println("Min coins needed using recursion : " + minCoinsRecursion(coins, m, target));
        System.out.println("Min coins needed using DP : " + minCoinsDP(coins, m, target));
        System.out.println("------------------------------------------------------");
        System.out.println("Min coins needed using DP2 : " + coinChange(coins, target));
    }

    private static int minCoinsDP(int[] coins, int m, int target) {
        int[][] dp = new int[target + 1][m + 1];

        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= target; i++) { // reason not to use buffer over flow max_Value +1 is negatrive :()
            dp[i][0] = target + 1;
        }

        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= m; j++) {
                if (i >= coins[j - 1]) {
                    dp[i][j] = Math.min(1 + dp[i - coins[j - 1]][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[target][m];
    }

    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        // Initialize first column with 0, as 0 coins are required to make amount 0.
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }

        // Initialize first row with a very large value that doesn't overflow when we
        // add 1 to it.
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = amount + 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
    }

    private static int minCoinsRecursion(int[] coins, int m, int target) {
        if (target == 0) {
            return 0;
        }
        int min_Count = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (coins[i] <= target) {
                count = minCoinsRecursion(coins, m, target - coins[i]) + 1;
                if (count < min_Count) {
                    min_Count = count;
                }
            }
        }
        return min_Count;
    }
}
