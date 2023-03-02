package leetCode;

import java.util.*;

public class duplicatesSubTrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> count = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        collect(root, count, ans);
        return ans;

    }

    private String collect(TreeNode node, Map<String, Integer> count, List<TreeNode> ans) {
        if (node == null) {
            return "#";
        }
        String serial = node.val + "," + collect(node.left, count, ans) + "," + collect(node.right, count, ans);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2) {
            ans.add(node);
        }
        return serial;
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
