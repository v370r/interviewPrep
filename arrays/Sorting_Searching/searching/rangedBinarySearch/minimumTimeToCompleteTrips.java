package arrays.Sorting_Searching.searching.rangedBinarySearch;

/*
 * https://leetcode.com/problems/minimum-time-to-complete-trips/
 * You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip.
Each bus can make multiple trips successively; that is, the next trip can start immediately after completing the current trip. Also, each bus operates independently; 
that is, the trips of one bus do not influence the trips of any other bus.
You are also given an integer totalTrips, which denotes the number of trips all buses should make in total. Return the minimum time required for all buses to complete at least totalTrips trips.
Input: time = [1,2,3], totalTrips = 5
Output: 3
Explanation:
- At time t = 1, the number of trips completed by each bus are [1,0,0]. 
  The total number of trips completed is 1 + 0 + 0 = 1.
- At time t = 2, the number of trips completed by each bus are [2,1,0]. 
  The total number of trips completed is 2 + 1 + 0 = 3.
- At time t = 3, the number of trips completed by each bus are [3,1,1]. 
  The total number of trips completed is 3 + 1 + 1 = 5.
So the minimum time needed for all buses to complete at least 5 trips is 3.
 
 */
public class minimumTimeToCompleteTrips {
    public static void main(String[] args) {
        int time[] = { 1, 2, 3 }, totalTrips = 5;
        System.out.println("Minimum No of trips needed : " + minimumTime(time, totalTrips));
    }

    private static long minimumTime(int[] time, int totalTrip) {
        Long totalTrips = new Long(totalTrip);
        int maxTime = Integer.MAX_VALUE;
        for (int i = 0; i < time.length; i++) {
            maxTime = Math.min(maxTime, time[i]);
        }
        long left = maxTime;
        long right = maxTime * totalTrips;
        while (left < right) {
            long mid = (left + right) / 2;
            if (isPossible(time, mid, totalTrips) < totalTrips) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static long isPossible(int[] time, long totalTime, long totalTrips) {
        long actualTrips = 0l;
        for (int t : time) {
            actualTrips += totalTime / t;
        }
        return actualTrips;
    }

}
