
package DynamicProgramming.geeksForGeeksTop20;

/**
 * LongestIncreasingSubsequence
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println("Longest increasing subsequence is : " + lis(arr));
    }

    private static int lis(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j < dp.length; j++) {
                if (dp[j] <= dp[i] && arr[i] <= arr[j]) {
                    dp[j] = dp[i] + 1;
                }
            }
        }

        return dp[arr.length - 1];
    }
}