package leetCode;

import java.util.*;

/*
 * Given an integer array nums, return the number of subarrays filled with 0.
  *A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class numberOfZeroFilledSubArrays {
    public static void main(String[] args) {
        int arr[] = { 0, 0, 0, 2, 0, 0 };
        System.out.println("Number of subArrays : " + zeroFilledSubarray(arr));

    }

    public static long zeroFilledSubarray(int[] nums) {
        long res = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                j = i + 1;
            else {
                res += i - j + 1;
            }
        }
        return res;
    }

    private static long subArrays(int[] arr) {
        Map<Long, Long> mp = new HashMap<>();
        long count = 0;
        Boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (flag) {
                    count++;
                } else {
                    count = 1;
                    flag = true;
                }
            } else if ((i == 0 || arr[i - 1] == 0) && arr[i] != 0) {
                flag = false;
                mp.put(count, mp.getOrDefault(count, (long) 0) + 1);
                count = 0;
            }
            if (i == arr.length - 1 && arr[i] == 0) {
                flag = false;
                mp.put(count, mp.getOrDefault(count, (long) 0) + 1);
            }
        }
        long res = (long) 0;
        for (Map.Entry<Long, Long> i : mp.entrySet()) {
            if (i.getKey() > 0) {
                res += i.getValue() * i.getKey() * (i.getKey() + 1) / 2;
            }

        }

        return res;
    }
}

class Solution {

    public static void main(String[] args) {
        int arr[] = { 0, 0, 0, 2, 0, 0 };
        System.out.println("Number of subArrays : " +
                zeroFilledSubarray(arr));
    }

    public static long zeroFilledSubarray(int[] nums) {
        long res = 0;
        for (int i = 0, j = 0; i < nums.length; ++i) {
            if (nums[i] != 0)
                j = i + 1;
            res += i - j + 1;
        }
        return res;
    }

}
