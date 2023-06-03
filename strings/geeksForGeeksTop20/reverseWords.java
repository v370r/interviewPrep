package strings.geeksForGeeksTop20;

import java.util.Arrays;

/*
 * Reverse words in a given string
 * Input : "Welcome to geeksforgeeks"
 * Output : "geeksforgeeks to Welcome"
 */
public class reverseWords {
    public static void main(String[] args) {
        String str = "Welcome to geeksforgeeks";
        System.out.println("reverse words for the string : " + reverseWord(str));
    }

    private static String reverseWord(String str) {
        String[] arr = str.split(" ");
        String[] resArr = new String[arr.length];
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            resArr[i] = arr[arr.length - i - 1];
        }
        for (int i = 0; i < resArr.length - 1; i++) {
            res += resArr[i] + " ";
        }
        res += resArr[resArr.length - 1];
        return res;

    }
}
