import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * https://leetcode.com/problems/simplify-path/
 * The canonical path should have the following format:
The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 */
public class unixPath {
    public static void main(String[] args) {
        String s = "/..";
        System.out.println("simplifying path : " + mySolution(s));

    }

    private static String mySolution(String s) {
        Deque<String> stack = new ArrayDeque<>();
        String[] charArray = s.split("/");
        for (String element : charArray) {
            if (element.equals("")) {
                continue;
            } else if (element.equals(".")) {
                continue;
            } else if (element.equals("..")) {
                stack.pollLast();
            } else {
                stack.addLast(element);
            }

        }

        return "/" + String.join("/", stack);
    }

    // Better solution
    public String simplifyPath(String path) {
        Deque<String> dirOrFiles = new ArrayDeque<>();
        for (String dirOrFile : path.split("/")) {
            if (!dirOrFiles.isEmpty() && dirOrFile.equals("..")) {
                dirOrFiles.removeLast();
            } else if (!dirOrFile.equals(".") && !dirOrFile.equals("") && !dirOrFile.equals("..")) {
                dirOrFiles.addLast(dirOrFile);
            }
        }
        StringBuilder simplified_path = new StringBuilder();
        for (String dirOrFile : dirOrFiles) {
            simplified_path.append("/").append(dirOrFile);
        }
        return simplified_path.length() == 0 ? "/" : simplified_path.toString();
    }

    // Wrong approach as path name may contain /..hidden we have to split before
    /*
     * private static String mySolution(String s) {
     * Character curr_char, popped_char;
     * Deque<Character> stack = new ArrayDeque<>();
     * 
     * for (int i = 0; i < s.length(); i++) {
     * popped_char = stack.peekLast();
     * curr_char = s.charAt(i);
     * 
     * if (popped_char == '/' && curr_char == '/') {
     * stack.removeLast();
     * stack.add(curr_char);
     * } else if (popped_char == '.' && curr_char == '.') {
     * stack.removeLast();
     * stack.remo
     * } else if (popped_char == '/' && curr_char == '.') {
     * stack.removeLast();
     * }
     * 
     * }
     * return null;
     * }
     */

}
