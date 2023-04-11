package contest9thApril;

import java.util.Arrays;

public class minimizeMaximumOfPairs {
    // FIXME:
    public static void main(String[] args) {
        int nums[] = { 10, 1, 2, 7, 1, 3 }, p = 2;
        System.out.println("Minimize maximum of pairs : " + searchMinimumMax(nums, p));

    }

    private static int searchMinimumMax(int[] nums, int p) {
        int low = 0, high = 0, mid;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            high = Math.max(nums[i], high);
        }
        while (low <= high) {
            mid = (low + high) / 2;
            if (isNotPossible(nums, p, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean isNotPossible(int[] nums, int p, int mid) {
        int i = 0, count = 0;
        while (i < nums.length - 1) {
            if (Math.abs(nums[i + 1] - nums[i]) > mid) {
                count++;
            }
            if (count == p) {
                return true;
            }
            i += 1;
        }
        return false;
    }
}
