package arrays.geeksForGeeksTop20;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class buySellStocks {

    public static void main(String[] args) {
        int[] arr = new int[] { 7, 1, 5, 3, 6, 4 };
        // System.out.println("max profit = : " + maxProfitInefficientSolution(arr));
        // System.out.println("max profit = : " + maxProfitEfficientSolution(arr));
        System.out.println("Max profit using max sub contiguours subaaray  approach: " + maxSubArray(arr));
        System.out.println("Max profit using indeces : " + profitsUsingStack(arr));
    }

    /*
     * Using max subarray method O(n) time and O(n) space
     * space can b changed to O(1) if we save in same array;
     */
    public static int maxSubArray(int[] arr) {
        int[] diff_array = new int[arr.length - 1];
        int diff_len = diff_array.length;
        for (int i = 0; i < diff_len; i++) {
            diff_array[i] = arr[i + 1] - arr[i];
        }
        System.out.println("Diff arrays : " + Arrays.toString(diff_array));

        int res_sum = 0;
        int curr_ = 0;
        for (int i = 0; i < diff_len; i++) {
            curr_ += diff_array[i];
            if (curr_ < diff_array[i]) {
                curr_ = diff_array[i];
            }
            if (curr_ > res_sum) {
                res_sum = curr_;
            }
        }
        return res_sum;
    }

    /*
     * O(n) -- time
     * O(1) -- space
     * efficient solution
     */
    private static int maxProfitEfficientSolution(int[] arr) {
        int min_element = arr[0];
        int max_Value = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - min_element > max_Value) {
                max_Value = arr[i] - min_element;
            } else if (arr[i] < min_element) {
                min_element = arr[i];
            }
        }
        return max_Value <= 0 ? 0 : max_Value;
    }

    /*
     * Inefficient solution
     * timelimit exceedign 202/211 passed
     */
    private static int maxProfitInefficientSolution(int[] arr) {
        int max_soFar = Integer.MIN_VALUE;
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int max_itr = Integer.MIN_VALUE;
            for (int j = i; j < len; j++) {
                max_itr = arr[j] - arr[i];
                if (max_itr > max_soFar) {
                    max_soFar = max_itr;
                }
            }

        }
        return max_soFar < 0 ? 0 : max_soFar;
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int maximumProfit = 0, minStockVal = Integer.MAX_VALUE;
        int i = 0;
        while (i < n) {
            minStockVal = Math.min(minStockVal, prices[i]);
            // whenever the price of current stock is greater then then the stock value
            // which we bought then only we will sell the stock
            if (prices[i] >= minStockVal)
                maximumProfit = Math.max(maximumProfit, prices[i] - minStockVal);
            i++;
        }
        return maximumProfit;
    }

    public static int profitUsingIndices(int[] prices) {
        int highIndex = 1, lowIndex = 0, maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[lowIndex] > prices[i]) {
                lowIndex = i;
            }
            if (prices[highIndex] < prices[i] && i != 0) {
                highIndex = i;
                maxProfit = Math.max(maxProfit, prices[highIndex] - prices[lowIndex]);
            }

        }
        return maxProfit;
    }

    // trying with stack
    public static int profitsUsingStack(int[] prices) {
        int len = prices.length;
        int prevMax = prices[len - 1], curr_max = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (prices[i] > prevMax) {
                prevMax = prices[i];
            }
            curr_max = Math.max(curr_max, prevMax - prices[i]);
        }
        return curr_max;
    }

}
