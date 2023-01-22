package arrays.geeksForGeeksTop20;

/*
 * also called as kandanes algorithm
 * foreach
 * ****meh = meh+a[i]
 * ****if(meh<a[i]){meh = a[i]}
 * ****if(msf <meh) { msf= meh}
 */
public class longestSumSubArray {
    public static void main(String[] args) {
        // int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 }; // ans should be 7
        // int a[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 }; // ans should be 6
        // int a[] = { 1 };
        int a[] = { 5, 4, -1, 7, 8 }; // ans should be 23
        int n = a.length;
        System.out.println(kadaneAlgorithm(a, n));
        System.out.println(bruteForce(a, n));
    }

    private static int kadaneAlgorithm(int[] a, int n) {
        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;
        for (int i : a) {
            curr_sum += i;
            if (curr_sum < i) {
                curr_sum = i;
            }
            if (max_sum < curr_sum) {
                max_sum = curr_sum;
            }
        }
        return max_sum;
    }

    // Note: fixed as i can be equal to j
    private static int bruteForce(int[] a, int n) {
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int curr_sum = 0;
            for (int j = i; j < a.length; j++) {
                curr_sum += a[j];
                if (max_sum < curr_sum) {
                    max_sum = curr_sum;
                }
            }
        }
        return max_sum;
    }
}
