package arrays.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Check if second array is subset Of another array
 */
public class arraysSubset {
    public static void main(String[] args) {
        int[] arr1 = { 11, 1, 13, 21, 3, 7 }, arr2 = { 11, 3, 7, 2 };
        checkSubset(arr1, arr2);
        checkSubsetUsingContains(arr1, arr2);
    }

    private static void checkSubsetUsingContains(int[] arr1, int[] arr2) {
        List<Integer> lis1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        List<Integer> lis2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        if (!lis1.containsAll(lis2)) {
            System.out.println("not a subset");
        }
    }

    private static void checkSubset(int[] arr1, int[] arr2) {
        if (arr2.length > arr1.length) {
            return;
        }
        List<Integer> lis = Arrays.stream(arr1).boxed().collect(Collectors.toList());

        Arrays.stream(arr2).forEach(i -> {
            if (!lis.contains(i)) {
                System.out.println("not subset");
            }
            ;
        });
        return;
    }
}
