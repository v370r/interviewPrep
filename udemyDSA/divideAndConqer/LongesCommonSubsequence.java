package udemyDSA.divideAndConqer;

/*
 * https://leetcode.com/problems/longest-common-subsequence/
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted
without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
 * 
 * 
 */
public class LongesCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "bsbininm", s2 = "jmjkbkjkv";
        System.out.println("Longest matching sequence using recursion : " + UsingRecursion(s1, s2));
        System.out.println("Using DP " + dpSolution(s1, s2));

    }

    private static int dpSolution(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    private static int UsingRecursion(String s1, String s2) {
        int index1 = 0, index2 = 0;
        return recursiveSolution(s1, index1, s2, index2);
    }

    private static int recursiveSolution(String s1, int index1, String s2, int index2) {
        if (index1 >= s1.length() || index2 >= s2.length()) {
            return 0;
        } else {
            if (s1.charAt(index1) == s2.charAt(index2)) {
                return 1 + max(recursiveSolution(s1, index1 + 1, s2, index2 + 1),
                        recursiveSolution(s1, index1 + 1, s2, index2), recursiveSolution(s1, index1, s2, index2 + 1));
            } else {
                return Math.max(recursiveSolution(s1, index1 + 1, s2, index2),
                        recursiveSolution(s1, index1, s2, index2 + 1));
            }
        }
    }

    public static int max(int x, int y, int z) {
        if (x <= y && x <= z) {
            return x;
        } else if (y <= z && y <= x) {
            return y;
        } else {
            return z;
        }
    }

}
