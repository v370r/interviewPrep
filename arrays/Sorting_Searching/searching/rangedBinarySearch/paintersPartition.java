package arrays.Sorting_Searching.searching.rangedBinarySearch;

public class paintersPartition {
    public static void main(String[] args) {
        int work[] = { 12, 34, 67, 90 }, painters = 2;
        System.out.println("Maximum time :" + painterspartition(work, painters));
    }

    private static int painterspartition(int[] work, int painters) {
        int low = Integer.MIN_VALUE, right = 0, mid;
        if (work.length < painters) {
            return -1;
        }
        for (int i = 0; i < work.length; i++) {
            low = Math.max(work[i], low);
            right += work[i];
        }

        while (low <= right) {
            mid = (low + right) / 2;
            if (isPossible(work, painters, mid)) {
                right = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean isPossible(int[] work, int painters, int mid) {
        int sum = 0;
        int workers = 0;
        for (int i = 0; i < work.length; i++) {
            sum += work[i];
            if (sum > mid) {
                sum = work[i];
                workers++;
            } else if (sum == mid) {
                sum = 0;
                workers++;
            }
            if (workers > painters) {
                return false;
            }

        }
        if (sum > 0) {
            workers++;
        }
        return painters >= workers;
    }
}
