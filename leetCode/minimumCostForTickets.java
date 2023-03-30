package leetCode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 * You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.
Train tickets are sold in three different ways:
a 1-day pass is sold for costs[0] dollars,
a 7-day pass is sold for costs[1] dollars, and
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.
For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
 */
public class minimumCostForTickets {
    public static void main(String[] args) {
        int[] days = { 1, 4, 6, 7, 8, 20 }, costs = { 2, 7, 15 };
        int startIndex = 0, curr_sum = 0;
        // System.out.println("Recursive solution : " + recursiveSolution(days, costs,
        // startIndex, curr_sum)); // Not
        // working..
        System.out.println("Dynamic programing solution : " + dpSolution(days, costs));
    }

    // TODO:
    private static int dpSolution(int[] days, int[] costs) {
        int[] dp = new int[366];
        dp[0] = 0;

        for (int i = 1; i < days[days.length - 1] + 1; i++) {
            dp[i] = min(dp[i - 1] + 2, dp[(i - 6) >= 0 ? (i - 6) : 0] + 7, dp[(i - 29 > 0) ? (i - 29) : 0] + 15);
        }

        System.out.println("DP :" + Arrays.toString(dp));
        return dp[days[days.length - 1]];
    }

    // FIXME:
    private static int recursiveSolution(int[] days, int[] costs, int startIndex, int sum) {
        int cost1 = 0, cost2 = 0, cost3 = 0, start7 = 0, start30 = 0;

        if (startIndex >= days.length) {
            return 0;
        }
        cost1 = costs[0] + recursiveSolution(days, costs, startIndex + 1, sum);

        for (int i = startIndex; i < days.length; i++) {
            if (days[i] <= days[startIndex] + 6) {
                start7 = i;
            }
        }
        cost2 = costs[1] + recursiveSolution(days, costs, start7 + 1, sum);

        for (int i = startIndex; i < days.length; i++) {
            if (days[i] <= days[startIndex] + 29) {
                start30 = i;
            }
        }
        cost3 = costs[2] + recursiveSolution(days, costs, start30 + 1, sum);
        return min(cost1, cost2, cost3);
    }

    private static int min(int x, int y, int z) {
        if (x <= y && x <= z) {
            return x;
        } else if (y <= z && y <= x) {
            return y;
        } else {
            return z;
        }
    }

}
