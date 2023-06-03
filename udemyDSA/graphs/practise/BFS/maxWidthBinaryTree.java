package udemyDSA.graphs.practise.BFS;

import java.util.*;

import udemyDSA.graphs.practise.Pair;

//https://leetcode.com/problems/maximum-width-of-binary-tree/
public class maxWidthBinaryTree {

    int maxWidth = 0;

    public static void main(String[] args) {
        List<Integer> list = List.of(0, 0, 0, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null,
                null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0,
                null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0,
                0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null,
                0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null,
                null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0,
                null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0,
                0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null,
                0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null,
                null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0,
                null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0,
                0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null);
        TreeNode root = convertListToBinaryTree(list, 0, list.size());
        System.out.println("max width " + new maxWidthBinaryTree().widthOfBinaryTree(root));
    }

    private static TreeNode convertListToBinaryTree(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode node;
        int mid = (start + end) / 2;
        if (list.get(mid) == null) {
            node = null;
        } else {
            node = new TreeNode(list.get(mid));
        }

        node.left = convertListToBinaryTree(list, start, mid - 1);
        node.right = convertListToBinaryTree(list, mid + 1, end);

        return node;
    }

    // internet solution
    public int widthOfBinaryTreeInternet(TreeNode root) {
        if (root == null)
            return 0;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            int levelStart = queue.peek().getValue();
            int index = 0;

            for (int i = 0; i < levelLength; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                index = pair.getValue();

                if (node.left != null) {
                    queue.add(new Pair<>(node.left, 2 * index));
                }

                if (node.right != null) {
                    queue.add(new Pair<>(node.right, 2 * index + 1));
                }
            }

            maxWidth = Math.max(maxWidth, index - levelStart + 1);
        }

        return maxWidth;
    }

    // TODO: My solution is throwing TLE
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode currNode;
        int curr_max = 0;
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            currNode = queue.peek();
            if (currNode == null) {
                curr_max = findLength(queue);
                if (curr_max == 0) {
                    break;
                }
                maxWidth = Math.max(curr_max, maxWidth);
                queue.add(null);
            } else {
                // add left
                queue.add((currNode.left != null || (currNode.left != null && currNode.left.val != -1)) ? currNode.left
                        : hashNode());
                queue.add((currNode.right != null || (currNode.right != null && currNode.right.val != -1))
                        ? currNode.right
                        : hashNode());
            }
            queue.poll();
        }
        return maxWidth;
    }

    public static int findLength(Queue<TreeNode> queue) {
        int i = -1, j = -1, iteration = 0;
        TreeNode currNode;
        Iterator<TreeNode> itr = queue.iterator();
        while (itr.hasNext()) {
            currNode = itr.next();
            if (currNode == null) {
                continue;
            } else if (currNode.val != -1 && i == -1) {
                i = iteration;
            } else if (currNode.val != -1) {
                j = iteration;
            }
            iteration++;
        }

        if (i == -1 && j == -1) {
            return 0;
        } else if (j == -1) {
            return 1;
        } else {
            return j - i + 1;
        }
    }

    public TreeNode hashNode() {
        return new TreeNode(-1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
