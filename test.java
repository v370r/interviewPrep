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
