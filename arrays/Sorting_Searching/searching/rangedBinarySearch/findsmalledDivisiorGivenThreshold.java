package arrays.Sorting_Searching.searching.rangedBinarySearch;

/*
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 * 
 * Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result.
 * Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
Each result of the division is rounded to the nearest integer greater than or equal to that element. 
(For example: 7/3 = 3 and 10/2 = 5).
The test cases are generated so that there will be an answer.
 */
public class findsmalledDivisiorGivenThreshold {
    public static void main(String[] args) {
        int num[] = { 1, 2, 5, 9 }, threshold = 6;
        System.out.println("Smallest divisor to reach threshold : " + smallestDivisor(num, threshold));
    }

    private static int smallestDivisor(int[] num, int threshold) {
        int low = 1, high = Integer.MIN_VALUE, mid = 0;
        for (int i = 0; i < num.length; i++) {
            high = Math.max(high, num[i]);
        }
        if (num.length == threshold) {
            return high;
        }
        while (low <= high) {
            mid = (low + high) / 2;
            if (isPossible(num, mid, threshold)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) low;
    }

    private static boolean isPossible(int[] num, long mid, int threshold) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += Math.ceil((1.0 * num[i]) / mid);
            if (sum > threshold) {
                return true;
            }
        }
        return sum > threshold;
    }

}
