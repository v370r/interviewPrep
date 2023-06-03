package arrays.geeksForGeeksTop20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class sort012 {
    public static void main(String[] args) {
        List<Integer> arr = createTestDataSet(10);
        sortList(arr);
    }

    /*
     * May need extra space can be done without extra space
     */
    private static void sortList(List<Integer> arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            if (map.get(arr.get(i)) == null) {
                map.put(arr.get(i), 1);
            } else {
                int curr = map.get(arr.get(i)) + 1;
                map.put(arr.get(i), curr);
            }
        }
        System.out.println(map.toString());
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {

            // Printing all elements of a Map
            for (int i = 0; i < set.getValue(); i++) {
                System.out.print(set.getKey() + " ");
            }
        }
    }

    private static List<Integer> createTestDataSet(int length) {
        Random rd = new Random(); // creating Random object
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            arr.add(i, Integer.valueOf(rd.nextInt(3))); // storing random integers in an array
            System.out.print(arr.get(i) + " "); // printing each array element
        }
        return arr;
    }
}
