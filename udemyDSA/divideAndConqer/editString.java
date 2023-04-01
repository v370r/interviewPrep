/*
 * https://leetcode.com/problems/edit-distance/
 * s1 and s2 are two strings
 * convewrt s1 to s2 using delete , update or insert
 * find minimum cost
 */
public class editString {
    public static void main(String[] args) {
        String s1 = "dinitrophenylhydrazine";
        String s2 = "acetylphenylhydrazine";
        // System.out.println("minimum number of operations needed using recursive
        // emthod : " + recursiveSolution(s1, s2));
        System.out.println("DP solutions : " + dpSolution(s1, s2));
    }

    private static int dpSolution(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1]; // shouldnt use length only have to use len+1 as 0,0 case

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(1 + dp[i - 1][j], 1 + dp[i][j - 1], 1 + dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    private static int recursiveSolution(String s1, String s2) {
        int index1 = 0, index2 = 0;
        return recursiveSolution(s1, index1, s2, index2);
    }

    private static int recursiveSolution(String s1, int index1, String s2, int index2) {
        if (index1 == s1.length()) {
            return s2.length() - index2;
        }
        if (index2 == s2.length()) {
            return s1.length() - index1;
        }
        if (s1.charAt(index1) == s2.charAt(index2)) {
            return recursiveSolution(s1, index1 + 1, s2, index2 + 1);
        }
        return min(1 + recursiveSolution(s1, index1 + 1, s2, index2),
                1 + recursiveSolution(s1, index1, s2, index2 + 1),
                1 + recursiveSolution(s1, index1 + 1, s2, index2 + 1));

    }

    private static int min(int i, int j, int k) {
        if (i < j && i < k) {
            return i;
        } else if (j < k && j < i) {
            return j;
        } else {
            return k;
        }
    }

}
