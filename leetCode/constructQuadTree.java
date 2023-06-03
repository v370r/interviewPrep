package leetCode;

/*
 * https://leetcode.com/problems/construct-quad-tree/
 * 
 * A Quad-Tree is a tree data structure in which each internal node has exactly four children. Besides, each node has two attributes:
 * 
 *val: True if the node represents a grid of 1's or False if the node represents a grid of 0's.
isLeaf: True if the node is leaf node on the tree or False if the node has the four children.
 */
public class constructQuadTree {
    public static void main(String[] args) {
        int[][] grid = new int[10][10];
        Node newNode = construct(grid);

    }

    private static Node construct(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }
        return construct(grid, 0, 0, grid.length);
    }

    private static Node construct(int[][] grid, int x1, int y1, int length) {
        // return leaf node if all values are same
        if (same(grid, x1, y1, length)) {
            return new Node(grid[x1][y1] == 1, true);
        } else {
            Node root = new Node(false, false);
            root.topLeft = construct(grid, x1, y1, length / 2);
            root.topRight = construct(grid, x1, y1 + length / 2, length / 2);
            root.bottomLeft = construct(grid, x1 + length / 2, y1, length / 2);
            root.bottomRight = construct(grid, x1 + length / 2, y1 + length / 2, length / 2);
            return root;
        }

    }

    private static boolean same(int[][] grid, int x1, int y1, int length) {
        for (int i = x1; i < x1 + length; i++) {
            for (int j = y1; j < y1 + length; j++) {
                if (grid[i][j] != grid[x1][y1]) {
                    return false;
                }
            }

        }
        return true;
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
