package leetCode;

/*
 * You are given an integer array nums and two integers minK and maxK.

 * A fixed-bound subarray of nums is a subarray that satisfies the following conditions:

 * The minimum value in the subarray is equal to minK.
 * The maximum value in the subarray is equal to maxK.
 * Return the number of fixed-bound subarrays.

 * A subarray is a contiguous part of an array.
 */

public class subArraysWithFixedBounds {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 2, 7, 5 };
        int mink = 1, maxK = 5;
        System.out.println("Count subArrays with fixed bounds : " + countSubArray(nums, mink, maxK));
    }

    private static int countSubArray(int[] nums, int mink, int maxK) {
        int prevMin = -1, prevMax = -1, j = -1, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < mink || nums[i] > maxK) {
                j = i;
            }
            if (nums[i] == mink) {
                prevMin = i;
            }
            if (nums[i] == maxK) {
                prevMax = i;
            }
            ans += Math.max(0, Math.min(prevMax, prevMin) - j);
        }
        return ans;
    }
}
