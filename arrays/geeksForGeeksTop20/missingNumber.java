package arrays.geeksForGeeksTop20;

import java.util.Arrays;

public class missingNumber {
    public static void main(String[] args) {
        int a[] = { 1, 2, 4, 3, 6, 5, 7, 9 };
        System.out.println(missingNumberSolve(a));
    }

    private static int missingNumberSolve(int[] a) {
        int len = a.length, curr_sum = 0;
        int expSum = (len + 1) * (len + 2) / 2;
        System.out.println(Arrays.stream(a).summaryStatistics());
        curr_sum = Arrays.stream(a).sum();
        return expSum - curr_sum;

    }

}
