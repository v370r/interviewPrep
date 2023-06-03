package DynamicProgramming.geeksForGeeksTop20;

public class subsetSum {
    public static void main(String[] args) {
        int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9, len = set.length;
        System.out.println("is subset using recursion : " + subSet(set, len, sum));
        System.out.println("Subset Sum using Dynamic programming : " + subsetSumDp(set, len, sum));
    }

    private static boolean subsetSumDp(int[] set, int len, int sum) {
        boolean[][] dp = new boolean[sum + 1][len + 1];
        for (int i = 0; i <= sum; i++) {
            dp[i][0] = false;
        }

        for (int i = 0; i <= len; i++) { // if sum is 0 always true
            dp[0][i] = true;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= len; j++) {
                dp[i][j] = dp[i][j - 1];
                if (set[j - 1] <= i) {
                    dp[i][j] = dp[i][j - 1] || dp[i - set[j - 1]][j - 1];
                }
            }
        }

        return dp[sum][len];
    }

    private static boolean subSet(int[] set, int len, int sum) {
        if (sum == 0) {
            return true;
        }
        if (len == 0) {
            return false;
        }

        if (set[len - 1] > sum) {
            return subSet(set, len - 1, sum);
        }
        return subSet(set, len - 1, sum) || subSet(set, len - 1, sum - set[len - 1]);
    }
}
