package arrays.Sorting_Searching.searching.rangedBinarySearch;

import java.util.Arrays;

/**
 * numberOfFlowersInFullBloom
 * https://leetcode.com/problems/number-of-flowers-in-full-bloom/description/
 * 
 * You are given a 0-indexed 2D integer array flowers, where flowers[i] =
 * [starti, endi] means the ith flower will be in full bloom from starti to endi
 * (inclusive). You are also given a 0-indexed integer array people of size n,
 * where poeple[i] is the time that the ith person will arrive to see the
 * flowers.
 * Return an integer array answer of size n, where answer[i] is the number of
 * flowers
 * that are in full bloom when the ith person arrives.
 * 
 * Input: flowers = [[1,6],[3,7],[9,12],[4,13]], poeple = [2,3,7,11]
 * Output: [1,2,2,2]
 * Explanation: The figure above shows the times when the flowers are in full
 * bloom and when the people arrive.
 * For each person, we return the number of flowers in full bloom during their
 * arrival.
 */
public class numberOfFlowersInFullBloom {
    public static void main(String[] args) {
        int[] flowers[] = { { 36, 39 }, { 29, 49 }, { 32, 35 }, { 14, 43 }, { 42, 49 }, { 48, 48 }, { 32, 46 },
                { 6, 41 }, { 14, 19 } }, people = { 14, 4 };
        System.out.println(
                "No of flowers that blooms during arrival : " + Arrays.toString(noOfFlowersBloom(flowers, people)));
    }

    private static int[] noOfFlowersBloom(int[][] flowers, int[] people) {
        int[] startArray = new int[flowers.length];
        int[] endArray = new int[flowers.length];
        int[] res_ = new int[people.length];
        for (int i = 0; i < flowers.length; i++) {
            startArray[i] = flowers[i][0];
            endArray[i] = flowers[i][1];
        }
        Arrays.sort(startArray);
        System.out.println("sorted start Array : " + Arrays.toString(startArray));
        Arrays.sort(endArray);
        System.out.println("sorted ending array : " + Arrays.toString(endArray));
        for (int i = 0; i < people.length; i++) {
            int no0fFlowersBoomed = binarySearchUpperBound(startArray, people[i]);
            int noOfFlowersDied = binarySearchLowerBound(endArray, people[i]);
            res_[i] = no0fFlowersBoomed - noOfFlowersDied;
            System.out.println("upper bound : " + no0fFlowersBoomed + " lower bound : " + noOfFlowersDied);
        }

        return res_;
    }

    private static int binarySearchUpperBound(int[] startArray, int person) {
        int low = 0, high = startArray.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (startArray[mid] <= person) {
                low = mid + 1;
            } else if (startArray[mid] > person) {
                high = mid - 1;
            }
        }
        return high + 1;
    }

    private static int binarySearchLowerBound(int[] startArray, int person) {
        int low = 0, high = startArray.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (startArray[mid] < person) {
                low = mid + 1;
            } else if (startArray[mid] > person) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;

    }

}