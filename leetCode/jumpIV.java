package leetCode;

public class jumpIV {
    public static void main(String[] args) {
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
        System.out.println("min jumps needed : " + jumps(arr, 0));
    }

    private static int jumps(int[] arr, int curr_ind) {
        int ans = 0;
        if (curr_ind == arr.length) {
            return ans;
        }
        if (curr_ind+1< arr.length) {
            ans = ans+1;
        }
        if()
    }
}
