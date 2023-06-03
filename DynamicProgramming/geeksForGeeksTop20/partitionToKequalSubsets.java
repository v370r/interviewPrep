package DynamicProgramming.geeksForGeeksTop20;

/*
 * Given an integer array nums and an integer k, return true 
 * if it is possible to divide this array into k non-empty subsets whose sums are all equal.
 */
// FIXME: Wrong code :(
public class partitionToKequalSubsets {
    public static void main(String[] args) {
        int nums[] = new int[] { 2, 2, 2, 2, 3, 4, 5 }, k = 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k == 1) {
            System.out.println("Cant do partitions");
        } else {
            sum = sum / k;
            System.out.println("is Equal partitions possible ? : " + isPartitionPossible(nums, sum, nums.length));
        }

    }

    private static int isPartitionPossible(int[] nums, int sum, int length) {
        int[][] dp = new int[sum + 1][length + 1];
        for (int i = 0; i < sum + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < length + 1; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= length; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= nums[j - 1]) {
                    dp[i][j] = dp[i][j - 1] + dp[i - nums[j - 1]][j - 1];
                }
            }
        }
        return dp[sum][length];
    }
}
