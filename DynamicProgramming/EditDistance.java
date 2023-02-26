package DynamicProgramming;

/*
 * Commonly used in spell correction 
 * === user types graffee ;  which is the closet word?
 * 
 * computational biology align two nucleodites
 * 
 * for reference material : https://web.stanford.edu/class/cs124/lec/med.pdf
 */
public class EditDistance {
    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(editDistDP(
                str1, str2, str1.length(), str2.length()));
    }

    private static int editDistDP(String str1, String str2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(dp[i - 1][j], // Insert
                            dp[i][j - 1], // Delete
                            dp[i - 1][j - 1]); // replace
                }
            }
        }
        return dp[m][n];
    }

    private static int min(int x, int y, int z) {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }

}
