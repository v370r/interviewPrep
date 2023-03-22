package arrays.Sorting_Searching.searching.rangedBinarySearch;

/*
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * You are given an integer array bloomDay, an integer m and an integer k.
You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
 */
public class minimumDaysForBoquets {

    public static void main(String[] args) {
        int bloomDay[] = { 1, 10, 3, 10, 2 }, m = 3, k = 2; // m => no of boquets, k=> adjacent
        System.out.println("Minimum no of days required to create a boquet :" + minimumDays(bloomDay, m, k));
    }

    private static int minimumDays(int[] bloomDay, int m, int k) {
        int left = 0, right = 0, mid = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            right = Math.max(right, bloomDay[i]);
        }
        int tempMax = right;
        while (left <= right) {
            mid = (left + right) / 2;
            if (checkBloomPossible(bloomDay, m, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left > tempMax ? -1 : left;
    }

    private static boolean checkBloomPossible(int[] bloomDay, int m, int k, int mid) {
        int taken = 0, count = 0;
        int currIndx = 0;
        while (currIndx < bloomDay.length) {
            if (((bloomDay[currIndx] - mid) <= 0)) {
                count++;
                if (count == k) {
                    count = 0;
                    taken++;
                }
            } else {
                count = 0;
            }
            currIndx++;
            if (taken >= m) {
                return true;
            }
        }
        return taken >= m;
    }

}
