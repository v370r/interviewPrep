package arrays.geeksForGeeksTop20;

import java.util.ArrayList;
import java.util.List;

/*
 * Sub array with Given sum
 * ---------------------------
 * can be done brute forcely using  i  and j and find all sub arrays with two for loops  i++ {j++ and find the sum (
 *                           applicable for both +ve and -ve)}
 * 
 * can be done using sliding window method but all must be *POSITIVE* 
 *           i++       j++{ if currsum_> amount i--(remove start amount)}
 * 
 */

public class subArrayWithGivenSum {
    public static void main(String[] args) {
        int sum = 7;
        int[] a = { 1, 4, 0, 0, 3, 10, 5 };
        int length = a.length;
        System.out.println(findSubArrayUsingSlididngWindow(a, length, sum).toString());
    }

    private static List<Integer> findSubArrayUsingSlididngWindow(int[] a, int length, int sum) {
        List<Integer> lis = new ArrayList<>(2);
        int start = 0, i = 0;
        int currsum_ = 0;
        while (i < length) {
            if (currsum_ > sum) {
                currsum_ -= a[start];
                start += 1;
            } else if (currsum_ == sum) {
                lis.add(start + 1);
                lis.add(i);
                return lis;
            } else {
                currsum_ += a[i];
                i++;
            }
        }
        return lis;
    }
}
