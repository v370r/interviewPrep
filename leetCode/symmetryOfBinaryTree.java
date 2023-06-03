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
    public boolean isSymmetric(TreeNode root) {
        // return checkIsSymmetric(root,root);
        return checkSymmertyUsingQueue(root);
    }

    private boolean checkSymmertyUsingQueue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode tempLeft = q.remove();
            TreeNode tempRight = q.remove();

            if (tempLeft == null && tempRight == null) {
                continue;
            }

            if ((tempLeft != null && tempRight == null) || (tempLeft == null && tempRight != null)) {
                return false;
            }

            if (tempLeft.val != tempRight.val) {
                return false;
            }
            q.add(tempLeft.left);
            q.add(tempRight.right);
            q.add(tempLeft.right);
            q.add(tempRight.left);
        }
        return true;
    }

    private boolean checkIsSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) && checkIsSymmetric(t1.right, t2.left) && checkIsSymmetric(t1.left, t2.right);
    }
}