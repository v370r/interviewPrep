package udemyDSA.linkedList.singleLinkedList;

public class Main {
    public static void main(String[] args) {
        singleLinkedList sLL = new singleLinkedList();
        sLL.createSingleLinkedList(5);
        // traverseLinkedList();
        // searchinLinkedList();
        // deleteNodeInLinkedList();
        deleteSingleLinkedList();
    }

    private static void deleteNodeInLinkedList() {
        singleLinkedList sLL = createLinkedList();
        sLL.traverseSingleLinkedList();
        sLL.deletionOfNode(3); // Location not value
        sLL.searchNode(12);
        sLL.traverseSingleLinkedList();

    }

    private static void deleteSingleLinkedList() {
        singleLinkedList sLL = createLinkedList();
        sLL.traverseSingleLinkedList();
        sLL.deleteSingleLinkedList();
        sLL.traverseSingleLinkedList();
    }

    private static void searchinLinkedList() {
        singleLinkedList sLL = createLinkedList();
        sLL.searchNode(12);
    }

    private static void traverseLinkedList() {
        singleLinkedList sLL = createLinkedList();
        sLL.traverseSingleLinkedList();
    }

    private static singleLinkedList createLinkedList() {
        singleLinkedList sLL = new singleLinkedList();
        sLL.createSingleLinkedList(5);
        sLL.insertInLinkedList(6, 1);
        sLL.insertInLinkedList(3, 2);
        sLL.insertInLinkedList(12, 3);
        sLL.insertInLinkedList(9, 4);
        sLL.insertInLinkedList(13, 5);
        return sLL;
    }

}
