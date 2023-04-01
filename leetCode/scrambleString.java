package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/scramble-string/
 * techdose MCM problem
 */
public class scrambleString {
    Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        // String s1 = "abcdefghijklmnopq", s2 = "efghijklmnopqcadb";
        String s1 = "great", s2 = "rgeat";
        System.out.println("is this a scrambled word ? using recursion :" + recursiveSolution(s1, s2));
        System.out.println("is scrambled word ? using memorization :" + new scrambleString().memorization(s1, s2));
    }

    private boolean memorization(String s1, String s2) {
        if (s1.length() == 1) {
            return s1.equals(s2);
        }
        if (s1.equals(s2)) {
            return true;
        }
        String key = s1 + "*" + s2;
        if (map.get(key) != null) {
            return map.get(key);

        }
        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            f1[s1.charAt(i) - 'a']++;
            f2[s2.charAt(i) - 'a']++;
        }
        if (!Arrays.equals(f1, f2)) {
            map.put(key, false);
            return false;
        }
        int len = s1.length();
        for (int i = 1; i < len; i++) {
            if ((memorization(s1.substring(0, i), s2.substring(0, i))
                    && memorization(s1.substring(i), s2.substring(i))) ||
                    (memorization(s1.substring(0, i), s2.substring(len - i))
                            && memorization(s1.substring(i), s2.substring(0, len - i)))) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return true;
    }

    private static boolean recursiveSolution(String s1, String s2) {
        if (s1.length() == 1) {
            return s1.equals(s2);
        }
        if (s1.equals(s2)) {
            return true;
        }
        int len = s1.length();
        for (int i = 1; i < len; i++) {
            if ((recursiveSolution(s1.substring(0, i), s2.substring(0, i))
                    && recursiveSolution(s1.substring(i), s2.substring(i))) ||
                    (recursiveSolution(s1.substring(0, i), s2.substring(len - i))
                            && recursiveSolution(s1.substring(i), s2.substring(0, len - i)))) {
                return true;
            }
        }
        return false;
    }
}