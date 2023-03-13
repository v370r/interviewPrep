package leetCode;

import java.util.Arrays;

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
