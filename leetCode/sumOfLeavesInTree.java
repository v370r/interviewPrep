import java.util.*;

//FIXME:
public class sumOfLeavesInTree {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        TreeNode curr_node;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            curr_node = queue.poll();
            if (curr_node.left != null) {
                sum += curr_node.left.val;
            }
            if (curr_node.right != null) {
                queue.add(curr_node.right);
            }
        }
        return sum;
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
    }
}
