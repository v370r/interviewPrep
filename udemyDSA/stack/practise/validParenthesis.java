package udemyDSA.stack.practise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
 * https://leetcode.com/problems/valid-parentheses/
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 */
public class validParenthesis {
    public static void main(String[] args) {
        String s = "()))";
        System.out.println("is s a valid parentheses ? :" + isValidParenthesesStack(s));
    }

    // Using stacks better not use stacks throws exceptions with pop and peek if
    // empthy
    private static boolean isValidParenthesesStack(String s) {
        Character[] openings = { '(', '[', '{' };
        Character[] closings = { ')', ']', '}' };
        Character curr_stackChar;
        Character curr_stringChar;

        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        curr_stackChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                curr_stackChar = stack.peek();
            } else {
                curr_stackChar = null;
            }

            curr_stringChar = s.charAt(i);
            if (curr_stackChar == openings[0] && curr_stringChar == closings[0]) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (curr_stackChar == openings[1] && curr_stringChar == closings[1]) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (curr_stackChar == openings[2] && curr_stringChar == closings[2]) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                for (int j = 0; j < closings.length; j++) {
                    if (curr_stringChar == closings[j]) {
                        return false;
                    }
                }

                stack.add(curr_stringChar);
            }
        }

        return stack.size() > 0 ? false : true;
    }

    private static boolean isValidParentheses(String s) {
        Character[] openings = { '(', '[', '{' };
        Character[] closings = { ')', ']', '}' };
        int len = s.length();
        Character curr_stackChar;
        Character curr_stringChar;

        Deque<Character> stack = new ArrayDeque<>();
        Stack<Character> st1 = new Stack<>();
        stack.add(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            curr_stackChar = stack.peekLast();
            curr_stringChar = s.charAt(i);
            if (curr_stackChar == openings[0] && curr_stringChar == closings[0]) {
                stack.removeLast();
            } else if (curr_stackChar == openings[1] && curr_stringChar == closings[1]) {
                stack.removeLast();
            } else if (curr_stackChar == openings[2] && curr_stringChar == closings[2]) {
                stack.removeLast();
            } else {
                for (int j = 0; j < closings.length; j++) {
                    if (curr_stringChar == closings[j]) {
                        return false;
                    }
                }

                stack.addLast(curr_stringChar);
            }
        }

        return stack.size() > 0 ? false : true;
    }

    // better solution from internet using arrays;
    public boolean isValid(String s) {

        int i = -1;
        char[] stack = new char[s.length()];
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack[++i] = ch;
            else {
                if (i >= 0
                        && ((stack[i] == '(' && ch == ')')
                                || (stack[i] == '{' && ch == '}')
                                || (stack[i] == '[' && ch == ']')))
                    i--;
                else
                    return false;
            }
        }
        return i == -1;
    }

}
