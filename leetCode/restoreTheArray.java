import java.util.Arrays;

// https://leetcode.com/problems/restore-the-array/

/*
 * A program was supposed to print an array of integers.
 * The program forgot to print whitespaces and the array is printed as a string of digits s and all we know is that all integers in the array were in the range [1, k]
 * and there are no leading zeros in the array.
Given the string s and the integer k, return the number of the possible arrays that can be printed as s using the mentioned program.
Since the answer may be very large, return it modulo 109 + 7.
 */
public class restoreTheArray {
    static int mod = 1000000007;

    public static void main(String[] args) {
        String s = "48486250454844645287030712560644579294181";
        int k = 989;
        // System.out.println("No of ways the original array is " +
        // MySolutionRecursive(s, k));
        System.out.println("Dp solution " + dpSolution(s, k));
    }

    private static String dpSolution(String s, int k) {
        return null;
    }

    // TLE on s = "48486250454844645287030712560644579294181"
    private static int MySolutionRecursive(String s, int k) {

        return helperRecursive(s, k, 0);
    }

    // DP soultion from internet
    public int dfs(String s, long k, int i, int[] dp) {
        if (i == s.length())
            return 1;
        if (s.charAt(i) == '0')
            return 0;
        if (dp[i] != -1)
            return dp[i];

        int ans = 0;
        long num = 0;
        for (int j = i; j < s.length(); j++) {
            num = num * 10 + s.charAt(j) - '0';
            if (num > k)
                break;
            ans = (ans + dfs(s, k, j + 1, dp)) % 1000000007;
        }
        return dp[i] = ans;
    }

    public int numberOfArrays(String s, int k) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(s, k, 0, dp);
    }

    private static int helperRecursive(String s, int k, int index) {
        if (s.length() == index) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        int count = 0;
        for (int i = index; i < s.length(); i++) {
            String num = s.substring(index, i + 1);
            if (Long.parseLong(num) > k) {
                break;
            }
            count = (count + helperRecursive(s, k, i + 1)) % mod;
        }
        return count;
    }
}
