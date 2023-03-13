package udemyDSA.tree.theory.BinarySearch;

public class workingBinarySearch {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(70);
        bst.insert(50);
        bst.insert(90);
        bst.insert(30);
        bst.insert(60);
        bst.insert(80);
        bst.insert(100);
        bst.insert(20);
        bst.insert(40);
        bst.preOrder(bst.root);
        bst.inOrder(bst.root);
        bst.search(bst.root, 40);
        System.out.println("--------------------------");
        bst.inOrder(bst.root);
        bst.deleteNode(bst.root, 90);
        bst.inOrder(bst.root);
    }

}
