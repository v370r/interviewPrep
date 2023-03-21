package leetCode.contest18March;

import java.util.Arrays;

/*
 * You are given a 0-indexed integer array nums. You are allowed to permute nums into a new array perm of your choosing.
 *We define the greatness of nums be the number of indices 0 <= i < nums.length for which perm[i] > nums[i].
 *Return the maximum possible greatness you can achieve after permuting nums.
*Input: nums = [1,3,5,2,1,3,1]
// Output: 4
// Explanation: One of the optimal rearrangements is perm = [2,5,1,3,3,1,1].
// At indices = 0, 1, 3, and 4, perm[i] > nums[i]. Hence, we return 4.
 */
public class maximizegrateness {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 3, 3, 1, 1 };
        System.out.println("Greatneness of the array is : " + greatnessOfArray(arr));
    }

    private static int greatnessOfArray(int[] arr) {
        Arrays.sort(arr);
        int count = 0, maxLoc = arr.length - 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[maxLoc]) {
                count++;
                maxLoc--;
            }
        }
        return count;
    }
}

class Solution {
    public int maximizeGreatness(int[] paramArrayOfint) {
        Arrays.sort(paramArrayOfint);
        int i = 0;
        for (int b = 0; b < paramArrayOfint.length; b++)
            i += (paramArrayOfint[b] > paramArrayOfint[i]) ? 1 : 0;
        return i;
    }
}
