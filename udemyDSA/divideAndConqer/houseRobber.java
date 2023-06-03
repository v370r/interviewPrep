/**
 * houseRobber
 * N houses
 * no adjacent houses can be stolen
 * find max he can steal;
 */
public class houseRobber {

    public static void main(String[] args) {
        int[] N = { 6, 7, 1, 30, 8, 2, 4 };
        System.out.println("Maximum we can steal : " + usingRecursion(N));
        System.out.println("Using DP :" + dpSolution(N));
    }

    private static int dpSolution(int[] n) {
        int dp[] = new int[n.length + 2];
        for (int i = n.length - 1; i >= 0; i--) {
            dp[i] = Math.max(n[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }

    private static int usingRecursion(int[] n) {
        int index = 0;
        return maxSteal(n, index);
    }

    private static int maxSteal(int[] n, int index) {
        if (index >= n.length) {
            return 0;
        }
        return Math.max(n[index] + maxSteal(n, index + 2), maxSteal(n, index + 1));
    }
}