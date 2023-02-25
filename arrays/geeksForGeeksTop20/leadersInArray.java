package arrays.geeksForGeeksTop20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leadersInArray {
    public static void main(String[] args) {
        int[] arr = new int[] { 16, 17, 4, 3, 5, 2 };
        System.out.println("Leaders in given array : " + leaders(arr).toString());
    }

    private static List<Integer> leaders(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int max_val = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] > max_val) {
                res.add(arr[i]);
                max_val = arr[i];
            }
        }
        Collections.reverse(res);
        return res;
    }

}
