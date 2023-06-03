package arrays.Sorting_Searching.searching.rangedBinarySearch;

/*
 * https://leetcode.com/problems/split-array-largest-sum/
 * Given an integer array nums and an integer k, split nums into k non-empty subarrays 
 * such that the largest sum of any subarray is minimized.
  Return the minimized largest sum of the split.
A subarray is a contiguous part of the array.
Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 */
public class splitSubArrayMaxSum {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5 }, k = 2;
        System.out.println("Minimium largest sum is : " + minimumMaxSUM(nums, k));
    }

    private static int minimumMaxSUM(int[] nums, int k) {
        int low = Integer.MIN_VALUE, high = 0, mid;
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        while (low <= high) {
            mid = (low + high) / 2;
            if (checkIsPossible(nums, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static boolean checkIsPossible(int[] nums, int k, int mid) {
        int curr_Sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            curr_Sum += nums[i];
            if (curr_Sum >= mid) {
                if (curr_Sum == mid) {
                    count++;
                    curr_Sum = 0;
                } else {
                    count++;
                    curr_Sum = nums[i];
                }
            }
        }
        if (curr_Sum > 0) {
            count++;
        }
        return count > k;
    }

}
