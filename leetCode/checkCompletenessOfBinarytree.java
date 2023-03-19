package leetCode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        // return iscompletetree(root); wrong solution
        return checkByInOrder(root);

    }

    public static boolean checkByInOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int flag = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left == null && node.right != null) {
                return false;
            }

            if (node.left == null && node.right == null) {
                flag = 1;
            }

            if (node.left != null && node.right == null) {
                if (flag == 1) {
                    return false;
                }
                flag = 1;
            }
            if ((node.left != null) && (node.right != null) && (flag == 1)) {
                return false;
            }

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return true;
    }

    public static boolean iscompletetree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right != null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return true;
        }
        return iscompletetree(root.left) && iscompletetree(root.right);
    }
}
// outside solution

class SolutionOutside {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean seenNull = false;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                seenNull = true;
                continue;
            }

            if (seenNull) {
                return false;
            }

            queue.add(node.left);
            queue.add(node.right);
        }

        return true;
    }
}
