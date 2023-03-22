package arrays.Sorting_Searching.searching.rangedBinarySearch;

/*
 * There are several consecutive houses along a street, each of which has some money inside. There is also a robber, who wants to steal money from the homes, but he refuses to steal from adjacent homes.
 * The capability of the robber is the maximum amount of money he steals from one house of all the houses he robbed.
 * You are given an integer array nums representing how much money is stashed in each house. More formally, the ith house from the left has nums[i] dollars.
 * You are also given an integer k, representing the minimum number of houses the robber will steal from. It is always possible to steal at least k houses.
 * Return the minimum capability of the robber out of all the possible ways to steal at least k houses.
 */

/*
# why ranged binary  ? check if robber can rob houses money with money less than k
 * Ex:
 * Input: nums = [2,3,5,9], k = 2
Output: 5
Explanation: 
There are three ways to rob at least 2 houses:
- Rob the houses at indices 0 and 2. Capability is max(nums[0], nums[2]) = 5.
- Rob the houses at indices 0 and 3. Capability is max(nums[0], nums[3]) = 9.
- Rob the houses at indices 1 and 3. Capability is max(nums[1], nums[3]) = 9.
Therefore, we return min(5, 9, 9) = 5.
 */

/*
 * 1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= (nums.length + 1)/2
 */
public class hoursRobber4 {
    public static void main(String[] args) {
        int houses[] = { 2, 7, 9, 3, 1 }, k = 2;
        System.out.println("House can be robbed : " + housecanBeRobbed(houses, k));
    }

    private static long housecanBeRobbed(int[] houses, int k) {
        long left = 0, right = (long) 1e14, mid, ans = Integer.MAX_VALUE;
        while (left <= right) {
            mid = (left + right) / 2;
            if (checkFeasable(houses, mid, k)) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }

    private static boolean checkFeasable(int[] houses, long mid, int k) {
        int i = 0, n = houses.length;
        while (i < n) {
            if (houses[i] <= mid) {
                k--;
                i += 2;
            } else {
                i++;
            }
            if (k == 0) {
                return true;
            }

        }
        return k == 0;
    }
}
