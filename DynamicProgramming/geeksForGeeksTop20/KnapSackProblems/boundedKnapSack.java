package DynamicProgramming.geeksForGeeksTop20.KnapSackProblems;

public class boundedKnapSack {
    public static void main(String[] args) {
        int[] profit = { 60, 100, 120 };
        int[] weight = { 10, 20, 30 };
        int W = 50;
        System.out.println("find max profit using DP : " + knapSack(profit, weight, weight.length, W));
        System.out.println("If repetitions allowed Max profit : " + knapSackRep(profit, weight, weight.length, W));
    }

    private static int knapSackRep(int[] profit, int[] weight, int length, int W) {
        int[][] dp = new int[W + 1][length + 1];

        for (int i = 0; i <= W; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <= length; j++) {
                if (i >= weight[j - 1]) {
                    dp[i][j] = Math.max(profit[j - 1] + dp[i - weight[j - 1]][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[W][length];
    }

    private static int knapSack(int[] profit, int[] weight, int length, int W) {
        int[][] dp = new int[W + 1][length + 1];

        for (int i = 0; i <= W; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <= length; j++) {
                if (i >= weight[j - 1]) {
                    dp[i][j] = Math.max(profit[j - 1] + dp[i - weight[j - 1]][j - 1], dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[W][length];
    }
}
