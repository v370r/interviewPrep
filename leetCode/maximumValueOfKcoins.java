import java.util.Arrays;

/*
 * https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/solutions/3417927/recursion-top-down-bottom-up-easy-to-understand-code/
 */
public class maximumValueOfKcoins {
    public static void main(String[] args) {
        int piles[][] = { { 1, 100, 3 }, { 7, 8, 9 } }, k = 2;
        System.out.println("Maximum value of coins :" + maximumCoinsMysolution(piles, k));
    }

    private static int maximumCoinsMysolution(int[][] piles, int k) {
        int res = 0, coinsCount = 0;
        for (int i = 0; i < piles.length; i++) {
            for (int j = 1; j < piles[0].length; j++) {
                piles[i][j] = piles[i][j - 1] + piles[i][j];
                coinsCount++;
            }
            System.out.println(Arrays.toString(piles[i]));
        }

        return recursiveHelper(piles, k, 0, piles.length, 0, coinsCount + piles.length);
    }

    private static int recursiveHelper(int[][] piles, int k, int curr_pile, int size, int sum, int coinsCount) {
        if (coinsCount < k) {
            return Integer.MIN_VALUE;
        }

        for (int i = 0; i <= k; i++) {
            sum += Math.max(recursiveHelper(piles, k - i, curr_pile, size, sum), i);
        }
    }
}
