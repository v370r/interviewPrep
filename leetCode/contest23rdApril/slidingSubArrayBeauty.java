package contest23rdApril;

import java.util.*;

// return sliding beauty subarray
public class slidingSubArrayBeauty {
    public static void main(String[] args) {
        int nums[] = { -3, 1, 2, -3, 0, -3 }, k = 2, x = 1;
        System.out.println("sliding subarrays : " + Arrays.toString(slidingBeauty(nums, k, x)));
    }

    // TLE
    private static int[] slidingBeauty(int[] nums, int k, int x) {
        int n = nums.length, curr = 0;
        int[] res = new int[n - k + 1];

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        for (int i = 0; i < x; i++) {
            curr = minHeap.poll();
            temp.add(curr);
        }

        minHeap.addAll(temp);
        if (curr >= 0) {
            res[0] = 0;
        } else {
            res[0] = curr;
        }
        for (int i = k; i < n; i++) {
            minHeap.remove(nums[i - k]);
            minHeap.add(nums[i]);
            temp.removeAll(temp);
            for (int j = 0; j < x; j++) {
                curr = minHeap.poll();
                temp.add(curr);
            }
            minHeap.addAll(temp);
            if (curr >= 0) {
                res[i - k + 1] = 0;
            } else {
                res[i - k + 1] = curr;
            }
        }
        return res;
    }

    // FIX me
    private static int[] slidingBeauty2(int[] nums, int k, int x) {
        int n = nums.length, curr = 0;
        int[] res = new int[n - k + 1];

        int[] minHeap = new int[k];
        for (int i = 0; i < k; i++) {
            minHeap[i] = nums[i];
        }

        Arrays.sort(minHeap);

        curr = minHeap[x];

        if (curr >= 0) {
            res[0] = 0;
        } else {
            res[0] = curr;
        }
        for (int i = k; i < n; i++) {
            minHeap.remove(nums[i - k]);
            minHeap.add(nums[i]);
            temp.removeAll(temp);
            for (int j = 0; j < x; j++) {
                curr = minHeap.poll();
                temp.add(curr);
            }
            minHeap.addAll(temp);
            if (curr >= 0) {
                res[i - k + 1] = 0;
            } else {
                res[i - k + 1] = curr;
            }
        }
        return res;
    }
}
