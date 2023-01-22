package udemyDSA.arrays;

/*
 * check if one array is a permutation of other!
 * 
 */
public class permutations {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5 };
        int[] b = { 5, 1, 2, 3, 4 };
        System.out.println(permutation(a, b));
        System.out.println(betterSolution(a, b));
    }

    /*
     * Better solution ---- If sum is same and product is same then the same length
     * array is same :)
     * ------------------------------No need for two for loops
     */
    private static boolean betterSolution(int[] a, int[] b) {
        int sum1 = 0, sum2 = 0, mul1 = 0, mul2 = 0, len1 = a.length, len2 = b.length;
        if (len1 != len2) {
            return false;
        }
        for (int i = 0; i < len1; i++) {
            sum1 += a[i];
            sum2 += b[i];
            mul1 *= a[i];
            mul2 *= b[i];
        }
        return (sum1 == sum2) && (mul1 == mul2);
    }

    private static boolean permutation(int[] a, int[] b) {
        int len1 = a.length;
        int len2 = b.length;
        if (len1 != len2) {
            return false;
        }
        for (int i = 0; i < len1; i++) {
            boolean flag = false;
            for (int j = 0; j < len2; j++) {
                if (a[i] == b[j]) {
                    flag = true;
                }
            }
            if (flag == false) {
                return false;
            }
        }
        return true;
    }

}
