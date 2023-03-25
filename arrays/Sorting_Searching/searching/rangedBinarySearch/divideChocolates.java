package arrays.Sorting_Searching.searching.rangedBinarySearch;

/*
 * https://www.lintcode.com/problem/1817/?utm_source=sc-aliyun-cyc0322/
 * You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.
You're going to share this chocolate with K friends, so you need to cut K times to get K + 1 pieces, each of which is made up of a series of small pieces.
Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.
Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
Output: 6
Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
 */
public class divideChocolates {
    public static void main(String[] args) {
        int sweetness[] = { 1, 2, 2, 1, 2, 2, 1, 2, 2 }, K = 2;
        System.out.println("Divide chocolates and pick the minimum sweetness :" + minimumSweetness(sweetness, K));
    }

    private static int minimumSweetness(int[] sweetness, int k) {
        int low = Integer.MAX_VALUE, high = 0, mid = 0;
        for (int i = 0; i < sweetness.length; i++) {
            low = Math.min(low, sweetness[i]);
            high += sweetness[i];
        }

        while (low <= high) {
            mid = (low) + (high - low) / 2;
            if (isPossible(sweetness, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private static boolean isPossible(int[] sweetness, int k, int mid) {
        int sum = 0, dividents = 0;
        for (int i = 0; i < sweetness.length; i++) {
            sum += sweetness[i];
            if (sum >= mid) {
                sum = 0;
                dividents++;
            }
        }
        return dividents >= k + 1;
    }
}
