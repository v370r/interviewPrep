package leetCode;

import java.util.*;
import java.util.Map.Entry;

public class stringCompression {
    public static void main(String[] args) {
        char[] rep = new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        int indexAns = 0, index = 0;
        while (index < rep.length) {
            int count = 0;
            char curr_ = rep[index];
            while (index < rep.length && curr_ == rep[index]) {
                index++;
                count++;
            }
            System.out.println(rep[indexAns] + " " + count);
            rep[indexAns++] = curr_;
            if (count != 1) {
                for (char ch : Integer.toString(count).toCharArray())
                    rep[indexAns++] = ch;
            }
        }
        System.out.println(Arrays.toString(rep));
    }
}

class usingHashMap {
    public static void main(String[] args) {
        char[] rep = new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < rep.length; i++) {
            mp.put(rep[i], mp.getOrDefault(rep[i], 0) + 1);
        }
        int index = 0;
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            rep[index++] = entry.getKey();
            if (entry.getValue() != 1) {
                for (char c : Integer.toString(entry.getValue()).toCharArray()) {
                    rep[index++] = c;

                }
            }
        }
        System.out.println(Arrays.toString(rep));
    }
}
