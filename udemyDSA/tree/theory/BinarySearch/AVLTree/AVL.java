package udemyDSA.tree.theory.BinarySearch.AVLTree;

import udemyDSA.tree.theory.BinarySearch.BinaryNode;

public class AVL {
    BinaryNode root;

    AVL() {
        this.root = null;
    }

    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        System.out.print(node.value + " ");
        preOrder(node.right);
    }

    public void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.value + " ");
    }

    public void search(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("THe given value doesnt be found in  Binary Tree  ");
            return;
        } else if (node.value == value) {
            System.out.println("the given value is found in binary tree : " + value);
            return;
        } else if (node.value < value) {
            search(node.right, value);
        } else {
            search(node.left, value);
        }
    }

    // get height
    public int getHeight(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;

    }

    // rotateRight
    private BinaryNode rotateRight(BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // rotateLeft
    private BinaryNode rotateLeft(BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // get balance
    public int getBalance(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // insert BinaryNode
    private BinaryNode insertNode(BinaryNode node, int nodeValue) {
        if (node == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = nodeValue;
            newNode.height = 1;
            return newNode;
        } else if (nodeValue < node.value) {
            node.left = insertNode(node.left, nodeValue);
        } else {
            node.right = insertNode(node.right, nodeValue);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);
        if (balance > 1 && nodeValue < node.left.value) { // Left left condition
            return rotateRight(node);
        }
        if (balance > 1 && nodeValue > node.left.right.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);

        }
        if (balance < -1 && nodeValue > node.right.value) {
            return rotateLeft(node);
        }
        if (balance < -1 && nodeValue < node.right.value) {
            node.right = rotateRight(node);
            return rotateLeft(node);
        }
        return node;
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

}
