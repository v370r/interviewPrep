package leetCode;

class mintripsNeeded {
    public static void main(String[] args) {
        int arr[] = { 10000 };
        long trips = 10000000l;
        System.out.println("min trips needed : " + minimumTime(arr, trips));

    }

    public static long minimumTime(int[] time, long totalTrips) {
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