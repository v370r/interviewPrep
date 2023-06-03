package leetCode;

/*
 * intuition : 
 *          [2,3,4,7,11] , k = 5
 *           1,2,3,4,5           --- must be the elements that should be present
 *           1,1,1,3,6           --- missing elements present but 5 must be present in between
 *       ==  7+(5-3) = 9  should be present the kth element
 */
public class kthMissingNumber {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 7, 11 }, k = 5;
        System.out.println("Kth missing element i O(logn) : " + missingElement(arr, k));

    }

    private static int missingElement(int[] arr, int k) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] - (mid) <= k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low + k;
    }
}
