package leetCode;

import java.util.*;

/*
 * https://leetcode.com/problems/removing-stars-from-a-string/
 * You are given a string s, which contains stars *.
In one operation, you can:
Choose a star in s.
Remove the closest non-star character to its left, as well as remove the star itself.
Return the string after all stars have been removed.

Input: s = "leet**cod*e"
Output: "lecoe"
Explanation: Performing the removals from left to right:
- The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
- The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
- The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
There are no more stars, so we return "lecoe".
 */
public class removeStarsFromString {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println("String after removing the *'s " + removeStars(s));
    }

    // internet solution
    public static String removeStars(String s) {
        int len = s.length();
        char[] chars = new char[len];
        int index = len, count = 0;

        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '*') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    chars[--index] = c;
                }
            }
        }
        return String.valueOf(chars, index, len - index);
    }

    // my solution
    private static String removeStarsMySolution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                stack.pollLast();
            } else {
                stack.addLast(s.charAt(i));
            }
        }
        return stack.size() == 0 ? ""
                : stack.stream()
                        .map(e -> e.toString())
                        .reduce((acc, e) -> acc + e)
                        .get();
    }
}
