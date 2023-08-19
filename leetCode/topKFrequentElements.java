import java.util.*;

/**
 * topKFrequentElements
 */
public class topKFrequentElements {
    public static void main(String[] args) {
        int nums[] = { 1, 1, 1, 2, 2, 3, 3, 3, 3 }, k = 2;
        System.out.println("Top K frequent elements :" + Arrays.toString(topKElements(nums, k)));
    }

    private static int[] topKElements(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> lis = new LinkedList<Map.Entry<Integer, Integer>>(mp.entrySet());
        Collections.sort(lis, (a, b) -> b.getValue() - a.getValue());
        for (int j = 0; j < k; j++) {
            res[j] = lis.get(j).getKey();
        }

        return res;
    }

    private static int[] topKElementsGivenSortedOrder(int[] nums, int k) {
        List<Pairs> lis = new ArrayList<>();
        int[] res = new int[k];
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1 && nums[i] == nums[i + 1]) {
                count += 1;
            } else {
                lis.add(new Pairs(nums[i], count));
                count = 1;
            }
        }

        Collections.sort(lis, (a, b) -> b.frequency - a.frequency);

        for (int j = 0; j < k; j++) {
            res[j] = lis.get(j).number;
        }

        return res;
    }

}

/**
 * InnertopKFrequentElements
 */
class Pairs {
    int number;
    int frequency;

    /**
     * InnertopKFrequentElements
     */
    public Pairs(int number, int frequency) {
        this.number = number;
        this.frequency = frequency;
    }

}
