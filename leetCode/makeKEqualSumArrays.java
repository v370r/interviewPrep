package leetCode;

/*
 * https://leetcode.com/problems/make-k-subarray-sums-equal/description/
 */
public class makeKEqualSumArrays {
    public static void main(String[] args) {
        int arr[] = { 1, 4, 1, 3 }, k = 2;
        System.out.println("minimum operations required : " + makeSubKSumEqual(arr, k));
    }

    // FIXME:
    public static long makeSubKSumEqual(int[] arr, int k) {
        long totalSum = 0, subSetSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }

        subSetSum = Math.round(1.0 * totalSum / (arr.length)) * k;
        System.out.println("subsetSum :" + subSetSum);
        long subSetActualSum = 0, res = 0;
        for (int i = 0; i < k; i++) {
            subSetActualSum += arr[i];
            res = subSetSum - subSetActualSum;
        }
        for (int i = 1; i <= arr.length - k; i++) {
            if (subSetActualSum != subSetActualSum + (arr[i + k - 1] - arr[i - 1])) {
                subSetActualSum += (arr[i + k - 1] - arr[i - 1]);
                res += -1 * (subSetSum - subSetActualSum);
            } else {
                subSetActualSum += (arr[i + k - 1] - arr[i - 1]);
            }

        }

        return Math.abs(res);

    }
}
