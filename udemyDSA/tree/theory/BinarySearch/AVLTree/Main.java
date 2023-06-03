package udemyDSA.tree.theory.BinarySearch.AVLTree;

public class Main {
    public static void main(String[] args) {
        AVL newAvl = new AVL();
        newAvl.insert(5);
        newAvl.insert(10);
        newAvl.insert(15);
        newAvl.insert(20);
        newAvl.inOrder(newAvl.root);
        System.out.println("-----------------");
        newAvl.insert(3);
        newAvl.inOrder(newAvl.root);
    }
}
