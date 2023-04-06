package arrays.geeksForGeeksTop20;

/**
 * NoOfGoodPairs
 * https://leetcode.com/problems/number-of-good-pairs/
 * Given an array of integers nums, return the number of good pairs.
 * 
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 * 
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 */
public class NoOfGoodPairs {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 1, 1, 3 };
        System.out.println("No of good pairs : " + recursiveSolution(nums));
    }

    private static int recursiveSolution(int[] nums) {
        int startIndex = 0, endIndex = nums.length - 1;
        return recursiveHelper(nums, startIndex, endIndex);
    }

    private static int recursiveHelper(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return 0;
        } else if (nums[startIndex] == nums[endIndex]) {
            return 1 + recursiveHelper(nums, startIndex + 1, endIndex) +
                    recursiveHelper(nums, startIndex, endIndex - 1);
        } else {
            return Math.max(recursiveHelper(nums, startIndex + 1, endIndex),
                    recursiveHelper(nums, startIndex, endIndex - 1));
        }
    }

    private static int max(int x, int y, int z) {
        if (x >= y && x >= z) {
            return x;
        } else if (y >= z && y >= x) {
            return y;
        }
        return z;
    }

    public static int countPairs(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int count = 0;

        for (int i = left; i < right; i++) {
            if (arr[i] < arr[right]) {
                count++;
            }
        }

        return count + countPairs(arr, left, right - 1);
    }

}