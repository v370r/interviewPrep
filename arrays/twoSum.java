package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 18;
        System.out.println(Arrays.toString(twoSumSolution(nums, target)));
    }

    private static int[] twoSumSolution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x = 0; x < nums.length; x++) {
            if (map.get(target - nums[x]) != null) {
                return new int[] { x, map.get(target - nums[x]) };
            } else {
                map.put(nums[x], x);
            }
        }

        return new int[] {
        };
    }
}
