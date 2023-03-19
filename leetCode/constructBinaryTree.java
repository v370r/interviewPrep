package leetCode;

import java.util.*;

/*
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder 
 * is the postorder traversal of the same tree, construct and return the binary tree.
 * 
 */
public class constructBinaryTree {
    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20, 7 }, postorder = { 9, 15, 7, 20, 3 };
        Solution(inorder, postorder); // effiecient solution with hashset to reduce order
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);

        }

        return helper(map, postorder, 0, inorder.length - 1, 0, postorder.length - 1);

    }

    private TreeNode helper(Map<Integer, Integer> map, int[] postorder, int inLeft, int inRight, int poLeft,
            int poRight) {
        if (inLeft > inRight) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[poRight]);
        int inMid = map.get(root.val);

        root.left = helper(map, postorder, inLeft, inMid - 1, poLeft, poLeft + inMid - inLeft - 1);
        root.right = helper(map, postorder, inMid + 1, inRight, poRight - inRight + inMid, poRight - 1);
        return root;
    }

    private static TreeNode Solution(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart,
            int postEnd) {
        // Base case
        if (inStart > inEnd) {
            return null;
        }

        // Find the root node from the last element of postorder traversal
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of the root node in inorder traversal
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        // Recursively build the left and right subtrees
        int leftSize = rootIndex - inStart;
        int rightSize = inEnd - rootIndex;
        root.left = buildTree(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = buildTree(inorder, rootIndex + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1);

        return root;
    }
}
