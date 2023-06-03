package leetCode;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * You are given an array of strings nums and an integer k. Each string in nums represents an integer without leading zeros.

Return the string that represents the kth largest integer in nums.

Note: Duplicate numbers should be counted distinctly. For example, if nums is ["1","2","2"], "2" is the first largest integer, "2" is the second-largest integer, and "1" is the third-largest integer.
 */
public class kthLargestElement {
    public static void main(String[] args) {
        String arr[] = { "683339452288515879", "7846081062003424420", "4805719838", "4840666580043",
                "83598933472122816064", "522940572025909479", "615832818268861533", "65439878015", "499305616484085",
                "97704358112880133", "23861207501102", "919346676", "60618091901581", "5914766072",
                "426842450882100996", "914353682223943129", "97", "241413975523149135", "8594929955620533",
                "55257775478129", "528", "5110809", "7930848872563942788", "758", "4", "38272299275037314530",
                "9567700", "28449892665", "2846386557790827231", "53222591365177739", "703029", "3280920242869904137",
                "87236929298425799136", "3103886291279" };
        int k = 3;
        System.out.println("Kth Largest element : " + kthLargest(arr, k));
    }

    private static String kthLargest(String[] arr, int k) {
        BigInteger res = new BigInteger("0");
        PriorityQueue<BigInteger> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(new BigInteger(arr[i]));
        }
        for (int j = 0; j < k; j++) {
            res = maxHeap.remove();
        }
        return String.valueOf(res);
    }
}
