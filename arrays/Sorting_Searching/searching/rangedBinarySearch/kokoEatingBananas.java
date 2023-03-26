package arrays.Sorting_Searching.searching.rangedBinarySearch;

/*
 * https://leetcode.com/problems/koko-eating-bananas/
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas,
she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.
 */

public class kokoEatingBananas {
    public static void main(String[] args) {
        int piles[] = { 312884470 }, hours = 312884469;
        System.out.println("Koko speed of eating bananas : " + kokoEatingRate(piles,
                hours));
        // System.out.println(checkRate(piles, 3));
    }

    private static double kokoEatingRate(int[] piles, int hours) {
        int left = 1;
        int right = 0;
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (checkRate(piles, mid) > hours) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static double checkRate(int[] piles, double rate) {
        Double r = Double.valueOf(rate);
        Double hours = 0.0;
        for (int i = 0; i < piles.length; i++) {
            hours += Math.ceil(piles[i] / r);
        }
        return hours;
    }
}
