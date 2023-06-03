package arrays.Sorting_Searching.searching.rangedBinarySearch;

/*
 * https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/description/
 * You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed) 
 * that satisfies the following conditions:
  . nums.length == n
  . nums[i] is a positive integer where 0 <= i < n.
  . abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
  ' The sum of all the elements of nums does not exceed maxSum.
  . nums[index] is maximized.
Return nums[index] of the constructed array.

Note that abs(x) equals x if x >= 0, and -x otherwise.
 */
public class maximumValueAtGivenIndexInBoundedArray {
    public static void main(String[] args) {
        int n = 4, index = 2, maxSum = 6;
        System.out.println("the value at given index is 2 must be : " + maxValue(n, index, maxSum));

    }

    static long calcSum(long n) {
        return (n * (n + 1)) / 2;
    }

    static long getSum(int index, int val, int len) {
        int expectedLen = val - 1;
        int actualLen = len;
        long sum = 0;
        if (expectedLen > actualLen)
            sum = calcSum(expectedLen) - calcSum(expectedLen - actualLen);
        else {
            int extraLen = actualLen - expectedLen;
            long extraSum = extraLen * 1;
            sum = calcSum(expectedLen) + extraSum;
        }
        return sum;
    }

    static long getSumOfArray(int n, int index, int val) {
        // 1, 1, 1, (val - 2), (val - 1), val, (val - 1), (val - 2), 1, 1, 1
        long leftSum = getSum(index, val, index);
        long rightSum = getSum(index, val, n - index - 1);
        return (val + leftSum + rightSum);
    }

    public static int maxValue(int n, int index, int maxSum) {
        int low = 1, high = maxSum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sum = getSumOfArray(n, index, mid);
            if (sum <= maxSum) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return high;
    }
}
