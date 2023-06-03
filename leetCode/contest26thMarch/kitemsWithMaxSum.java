package leetCode.contest26thMarch;

/*
 * https://leetcode.com/problems/k-items-with-the-maximum-sum/solutions/
 * There is a bag that consists of items, each item has a number 1, 0, or -1 written on it.
You are given four non-negative integers numOnes, numZeros, numNegOnes, and k.
The bag initially contains:
numOnes items with 1s written on them.
numZeroes items with 0s written on them.
numNegOnes items with -1s written on them.
We want to pick exactly k items among the available items. Return the maximum possible sum of numbers written on the items.
 * 
 * 
 */
public class kitemsWithMaxSum {
    public static void main(String[] args) {
        int numOnes = 6, numZeros = 6, numNegOnes = 6, k = 13;
        System.out.println("Maximum Sum with given K is : " + maxKitemSum(numNegOnes, numZeros, numOnes, k));
    }

    private static int maxKitemSum(int numNegOnes, int numZeros, int numOnes, int k) {
        return k <= numOnes ? k
                : k <= numOnes + numZeros ? numOnes
                        : k > numOnes + numZeros + numNegOnes ? 0
                                : -((k - numZeros) - numOnes) + numOnes;
    }
}
