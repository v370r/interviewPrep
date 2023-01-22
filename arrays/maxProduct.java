package arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class maxProduct {
    public static void main(String[] args) {
        int[] a = { 1, 3, 4, 2, 1, 4, 3 };
        System.out.println(maxProduct(a));
    }

    private static boolean maxProduct(int[] a) {
        Set s = new HashSet<>(Arrays.asList(a));
        System.out.println(s);
        if (s.size() == a.length) {
            return true;
        }
        return false;
    }
}
