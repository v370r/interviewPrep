package arrays.Sorting_Searching.searching.rangedBinarySearch;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/maximum-tastiness-of-candy-basket/
 * You are given an array of positive integers price where price[i] denotes the price of the ith candy and a positive integer k.
The store sells baskets of k distinct candies. The tastiness of a candy basket is the smallest absolute difference of the prices of any two candies in the basket.
Return the maximum tastiness of a candy basket.

Input: price = [13,5,1,8,21,2], k = 3
Output: 8
Explanation: Choose the candies with the prices [13,5,21].
The tastiness of the candy basket is: min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8.
It can be proven that 8 is the maximum tastiness that can be achieved.
 */
public class maximumTastinessOfCandyBasket {
    public static void main(String[] args) {
        int price[] = { 13, 5, 1, 8, 21, 2 }, k = 3;
        System.out.println("Maximum tastiness : " + maximumTastiness(price, k));
    }

    private static int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int low = 0, high = Integer.MAX_VALUE, mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (isPossible(price, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    private static boolean isPossible(int[] price, int k, int mid) {
        int last = price[0], count = 1, i = 1;
        while (i < price.length) {
            if (price[i] - last >= mid) {
                last = price[i];
                count++;
            }
            i++;
            if (count >= k) {
                return true;
            }
        }
        return count >= k;
    }
}
