import java.util.*;
import java.util.Deque;

/*
 * https://leetcode.com/problems/validate-stack-sequences/
 * Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence
 * of push and pop operations on an initially empty stack, or false otherwise.
 */

public class validStackSequence {
    public static void main(String[] args) {
        int[] pushed = { 1, 0 },
                popped = { 1, 0 };
        System.out.println("is it valid stack sequence ? " + isValidMySolution(pushed, popped));
    }

    // Internet solution
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        for (int x : pushed) {
            pushed[i++] = x;
            while (i > 0 && pushed[i - 1] == popped[j]) {
                --i;
                ++j;
            }
        }
        return i == 0;
    }

    // internet solution using stacks
    public boolean validateStackSequencesUsingStacks(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.empty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

    // My solution beats 92%
    private static boolean isValidMySolution(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int curr_index = 1, poppedIndex = 0;
        stack.addLast(pushed[0]);
        while (poppedIndex <= popped.length - 1) {
            if (null != stack.peekLast() && popped[poppedIndex] == stack.peekLast()) {
                stack.pollLast();
                poppedIndex++;
            } else {
                if (curr_index < pushed.length) {
                    stack.addLast(pushed[curr_index++]);
                } else {
                    return false;
                }

            }
        }
        return true;
    }
}
