package udemyDSA.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class removeDuplicates {
    public static void main(String[] args) {
        int[] a = { 1, 2, 2, 3, 4, 4, 4, 5, 5, 6 };
        System.out.println(removeDups(a).toString());
        System.out.println(Arrays.toString(removeWithOutSet(a)));
    }

    private static Set<Integer> removeDups(int[] a) {
        Set<Integer> ret = new HashSet<>();
        for (Integer i = 0; i < a.length; i++) {
            ret.add(i);
        }
        return ret;
    }

    /*
     * Note: this method wont add the last element in the correct position so should
     * add it in correct position
     */
    private static int[] removeWithOutSet(int[] a) {
        int len = a.length, j = 0;
        for (int i = 0; i < len - 1; i++) {
            if (a[i] != a[i + 1]) {
                a[j++] = a[i];
            }
        }
        a[j] = a[len - 1];
        return a;
    }

}
