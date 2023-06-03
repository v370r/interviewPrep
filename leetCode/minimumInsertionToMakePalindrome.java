
public class minimumInsertionToMakePalindrome {
    public static void main(String[] args) {
        String s = "bbabcbcab";
        int i = 0, j = s.length() - 1;
        // System.out.println("Minimum insertions Required my solution " +
        // (j - mySolutionLPSRecursive(s, i, j)));
        System.out.println("Minimum insertions to make it palindrome " + (mySolutionLCPDP(s)));
    }

    private static int mySolutionLCPDP(String s) {
        int m = s.length();
        int[][] dp = new int[m + 1][m + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == s.charAt(m - 1 - (j - 1))) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][m];

    }

    // TLE
    private static int mySolutionLPSRecursive(String s, int i, int j) {
        while (i <= j) {
            if (i == j) {
                return 1;
            } else {
                if (s.charAt(i) == s.charAt(j)) {
                    return 2 + mySolutionLPSRecursive(s, i + 1, j - 1);
                } else {
                    return Math.max(mySolutionLPSRecursive(s, i, j - 1), mySolutionLPSRecursive(s, i + 1, j));
                }
            }
        }
        return 0;
    }

    // Bad way as in test case ccewnxhytsr answer is 10 bbut if we put all in
    // between c rstyhxnwe c ewnxhytsr
    private static int mySolution(String s) {
        int i = 0, j = s.length() - 1,
                res = 0;
        int flag = 0;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                if (flag == 0) {
                    i++;
                    res++;
                } else {
                    j--;
                    res++;
                }
                flag++;
                flag %= 2;
            }
        }

        return res;
    }
}
