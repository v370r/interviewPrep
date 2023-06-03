package udemyDSA.divideAndConqer;

/*
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Given a string s, return the longest palindromic  substring in s.
 * Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
 */
public class longestPalindrome {
    public static void main(String[] args) {
        String s1 = "ELRMENMET";
        System.out.println("Recursive solution for longest palindrome as string : " + recursiveSolution(s1));
        System.out.println("Recursive solution for longest palindrome as length : " + recursiveSolutionLen(s1));
        System.out.println("DP solution to get length :" + dpSolution(s1));
    }

    private static int dpSolution(String s) {
        int len1 = s.length();
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }

        int dp[][] = new int[len1 + 1][len1 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len1; j++) {
                if (s.charAt(i - 1) == reversed.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len1];
    }

    private static int recursiveSolutionLen(String s1) {
        int startIndex = 0, endIndex = s1.length() - 1;
        return recursiveHelperLen(s1, startIndex, endIndex);
    }

    private static int recursiveHelperLen(String s, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return 0;
        }
        if (startIndex == endIndex) {
            return 1;
        }
        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            return 2 + recursiveHelperLen(s, startIndex + 1, endIndex - 1);
        } else {
            return Math.max(recursiveHelperLen(s, startIndex + 1, endIndex),
                    recursiveHelperLen(s, startIndex, endIndex - 1));
        }

    }

    // -------------------------------------------------------------------------------------------------------------------------
    /*
     * If we want direct string instead of length
     */
    // --------------------------------------------------------------------------------------------------------------------------

    private static String recursiveSolution(String s1) {
        int startIndex = 0, endIndex = s1.length() - 1;
        return recursiveHelper(s1, startIndex, endIndex);
    }

    private static String recursiveHelper(String s, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return "";
        }
        if (startIndex == endIndex) {
            return String.valueOf(s.charAt(endIndex));
        }
        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            return String.valueOf(s.charAt(startIndex)) + recursiveHelper(s, startIndex + 1, endIndex - 1)
                    + String.valueOf(s.charAt(endIndex));
        } else {
            if (recursiveHelper(s, startIndex + 1, endIndex).length() > recursiveHelper(s, startIndex, endIndex - 1)
                    .length()) {
                return recursiveHelper(s, startIndex + 1, endIndex);
            } else {
                return recursiveHelper(s, startIndex, endIndex - 1);
            }
            // return Math.max(recursiveHelper(s, startIndex + 1, endIndex),
            // recursiveHelper(s, startIndex, endIndex - 1));
        }

    }

}
