package leetCode.contest18March;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * You are given an array nums consisting of positive integers.
 *Starting with score = 0, apply the following algorithm:
 *Choose the smallest integer of the array that is not marked. If there is a tie, choose the one with the smallest index.
 *Add the value of the chosen integer to score.
 *Mark the chosen element and its two adjacent elements if they exist.
 *Repeat until all the array elements are marked.
 *Return the score you get after applying the above algorithm.
 *Input: nums = [2,1,3,4,5,2]
 * Output: 7
 *Explanation: We mark the elements as follows:
    - 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,1,3,4,5,2].
    - 2 is the smallest unmarked element, so we mark it and its left adjacent element: [2,1,3,4,5,2].
    - 4 is the only remaining unmarked element, so we mark it: [2,1,3,4,5,2].
 */
public class findScoreAfterMarking {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, 1, 3, 2 };
        System.out.println("Score after marking : " + findScore(nums));
    }

    private static int findScore(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        int markArr[] = new int[nums.length], sum = 0;
        for (int j = 0; j < markArr.length; j++) {
            int currMin = queue.poll();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == currMin && markArr[i] != 1) {
                    if (i != 0 && i != nums.length - 1) {
                        markArr[i] = 1;
                        markArr[i - 1] = 1;
                        markArr[i + 1] = 1;
                    } else if (i == 0) {
                        markArr[i] = 1;
                        markArr[i + 1] = 1;
                    } else {
                        markArr[i] = 1;
                        markArr[i - 1] = 1;
                    }
                    sum += nums[i];
                }
            }
        }
        return sum;
    }

    private static boolean checkArrayIsfilled(int[] markArr) {
        for (int i = 0; i < markArr.length; i++) {
            if (markArr[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
