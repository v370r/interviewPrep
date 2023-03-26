package arrays.Sorting_Searching.searching.rangedBinarySearch;

/**
 * https://practice.geeksforgeeks.org/problems/minimize-max-distance-to-gas-station/1;
 * 
 * We have an horizontal number line. On that number line,
 * we have gas stations at positions stations[0], stations[1], ...,
 * stations[N-1], where N = size of the stations array.
 * Now, we add K more gas stations so that D, the maximum distance between
 * adjacent gas stations, is minimized.
 * We have to find the smallest possible value of D. Find the answer exactly to
 * 2 decimal places.
 * Ex:
 * N = 10
 * stations = [3,6,12,19,33,44,67,72,89,95]
 * K = 2
 * Output: 14.00 minimum distance
 * Explanation: Construction of gas stations at 86 locations
 */
public class minimizeMaxDistanceGastations {
    public static void main(String[] args) {
        int stations[] = { 3, 6, 12, 19, 33, 44, 67, 72, 89, 95 }, K = 2;
        System.out.println("Minimize maximum distance : " + minimizeMaxDistance(stations, K));
    }

    private static double minimizeMaxDistance(int[] stations, int k) {
        double low = 0.0, high = stations[stations.length - 1] - stations[0], mid = 0.0;

        while (high - low > 1e-6) {
            mid = (low + high) / 2;
            if (checkPossible(stations, k, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    private static boolean checkPossible(int[] stations, int k, double mid) {
        int count = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            count += (int) ((stations[i + 1] - stations[i]) / mid);
        }
        return count <= k;
    }
}