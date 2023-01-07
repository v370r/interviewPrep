package arrays.geeksForGeeksTop20;

import java.util.Arrays;

public class countTriplets {
    public static void main(String[] args) {
        int a[] = { 1, 5, 3, 2, 6 };
        int length = a.length;
        System.out.println(countTriplet(a, length));
    }

    // FIXME: algorithm isnt correct

    private static int countTriplet(int[] a, int length) {
        int count = 0;
        Arrays.sort(a);
        for (int i = 0; i < length - 2; i++) {
            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                if (a[i] + a[j] == a[k]) {
                    count += 1;
                    j += 1;
                } else if (a[i] + a[j] < a[k]) {
                    j += 1;
                } else {
                    k -= 1;
                }
            }
        }
        return count;
    }
}
