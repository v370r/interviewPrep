package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public static void main(String[] args) {
        int[] a = { 1, 4, 45, 6, 10, 8 };
        int target = 13;
        System.out.println(solve(a, target));
    }

    /**
     * @param a
     * @param target
     * @return
     */
    private static List<Integer> solve(int[] a, int target) {
        List<Integer> ret = new ArrayList<>();
        int length = a.length;
        Arrays.sort(a);
        for (int x = 0; x < length - 2; x++) {
            int y = x + 1;
            int z = length - 1;
            while (y < z) {
                int sum = (a[x] + a[y] + a[z]);
                if (sum == target) {
                    return Arrays.asList(a[x], a[y], a[z]);
                } else if (sum < target) {
                    y += 1;
                } else {
                    z -= 1;
                }
            }
        }
        return ret;
    }

}
