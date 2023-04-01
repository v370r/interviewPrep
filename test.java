import java.lang.invoke.StringConcatFactory;
import java.util.*;

class test123 {
    public static void main(String[] args) {
        Map<Integer, String> mp = new HashMap<>();
        mp.put(1, "vijay");
        for (Map.Entry<Integer, String> entries : mp.entrySet()) {
            System.out.println("key : " + entries.getKey() + " value : " + entries.getValue());
        }

        mp.put(1, "kumar");
        for (Map.Entry<Integer, String> entries : mp.entrySet()) {
            System.out.println("key : " + entries.getKey() + " value : " + entries.getValue());
        }
    }
}

/**
 * test
 */
class test2 {

    public static void main(String[] args) {
        int[] x;
        x = new int[3];
        // x={1,2,3}; tthrows error
        System.out.println(Arrays.toString(x));
        String s = "vijay kumar";
        System.out.println(s.substring(4));
        System.out.println(s.substring(0, 4));
        // System.out.println(Integer.valueOf(Integer.valueOf("0b11")));
        System.out.println('a' - 96);
    }
}
