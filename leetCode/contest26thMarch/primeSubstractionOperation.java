package leetCode.contest26thMarch;

import java.lang.Math;
import java.util.*;

/*
 *https://leetcode.com/problems/prime-subtraction-operation/
 You are given a 0-indexed integer array nums of length n.
You can perform the following operation as many times as you want:
Pick an index i that you haven’t picked before, and pick a prime p strictly less than nums[i], then subtract p from nums[i].
Return true if you can make nums a strictly increasing array using the above operation and false otherwise.
A strictly increasing array is an array whose each element is strictly greater than its preceding element. 
 */
public class primeSubstractionOperation {
    static Map<Integer, Boolean> primeMap = new HashMap<>();

    public static void main(String[] args) {
        int[] nums = { 15, 20, 17, 7, 16 };
        System.out.println("Can this be made strictly increasing ? :" + primeSubstraction(nums));

    }

    private static Boolean primeSubstraction(int[] nums) {
        int index = nums.length - 1, nearestPrime;
        while (index > 0) {
            if (nums[index - 1] >= nums[index]) {
                nearestPrime = findNearestPrime(nums[index - 1]);
                nums[index - 1] = nums[index - 1] - nearestPrime;

            }
            index--;
        }

        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] >= nums[i]) {
                return false;
            }
        }
        return true;
    }

    private static int findNearestPrime(int n) {
        int i = 1;
        if (n <= 1) {
            return -1;
        } else {
            while (n - i >= 1) {
                if (isPrime(n - i)) {
                    return n - i;
                }
                i++;
            }
        }
        return n - i;
    }

    private static boolean isPrime(int n) {
        if (primeMap.get(n) != null) {
            return primeMap.get(n);
        }
        if (n == 1) {
            return false;
        }

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                primeMap.put(n, false);
                return false;
            }
        }
        primeMap.put(n, true);
        return true;
    }

}
