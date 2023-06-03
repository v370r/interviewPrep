package DynamicProgramming.geeksForGeeksTop20;

/*
 * Given an integer N, the task is to obtain N, starting from 1 using minimum number of operations. The operations that can be performed in one step are as follows:
 *   Multiply the number by 2.
 *   Multiply the number by 3.
 *   Add 1 to the number.
 */
public class minimumOperations {
    public static void main(String[] args) {
        int n = 15;
        System.out.println("Minimum operations to get 15 from 1 usins recursion is : " + getKrecursion(n));
        System.out.println("Minimum operations using DP : " + getKrecursionDP(n));
    }

    // FIXME: wrong answ
    private static int getKrecursionDP(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            if (n % 2 == 0) {
                dp[i] = 1 + dp[i / 2];
            } else if (n % 3 == 0) {
                dp[i] = 1 + dp[i / 3];
            } else {
                dp[i] = 1 + dp[i - 1];
            }
        }
        return dp[n];
    }

    private static int getKrecursion(int n) {
        if (n == 1) {
            return 0;
        }

        int result = 1 + getKrecursion(n - 1);

        if (n % 2 == 0) {
            result = Math.min(result, 1 + getKrecursion(n / 2));
        }

        if (n % 3 == 0) {
            result = Math.min(result, 1 + getKrecursion(n / 3));
        }

        return result;
    }

}
