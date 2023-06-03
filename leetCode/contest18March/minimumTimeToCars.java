package leetCode.contest18March;

/*
 * You are given an integer array ranks representing the ranks of some mechanics. ranksi is the rank of the ith mechanic.
 *  A mechanic with a rank r can repair n cars in r * n2 minutes.
 * You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.
 * Return the minimum time taken to repair all the cars.
 * Note: All the mechanics can repair the cars simultaneously.
 */
public class minimumTimeToCars {

    public static void main(String[] args) {
        int ranks[] = { 5, 1, 8 }, cars = 6;
        System.out.println("Minimum time to complete all all car : " + findMinimum(ranks, cars));
    }

    private static long findMinimum(int[] ranks, int cars) {
        long left = 0, right = (long) (1e14);
        long mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (check(ranks, mid) >= cars) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int check(int[] ranks, long mid) {
        int cars = 0;
        for (int i = 0; i < ranks.length; i++) {
            cars += Math.sqrt(1.0 * mid / ranks[i]);
        }
        return cars;
    }
}
