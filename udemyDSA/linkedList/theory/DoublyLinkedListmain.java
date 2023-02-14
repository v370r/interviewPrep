package udemyDSA.linkedList.theory;

class doublyLinkedListMain {
    public static void main(String[] args) {
        doublyLinkedList dll = new doublyLinkedList();
        dll.createDLL(10);
        dll.insertDLL(2, 0);
        dll.insertDLL(3, 1);
        dll.insertDLL(4, 7);
        System.out.println(dll.tail.prev.value);
        dll.traverseDLL();
        dll.reversetraverseDLL();
        dll.searchNode(5);
        dll.deleteNode(0);
        dll.traverseDLL();
        dll.deleteDLL();
        dll.traverseDLL();
    }
}

class circularDoublyLinkedListMain {
    public static void main(String[] args) {
        circularDoublyLinkedList cdll = new circularDoublyLinkedList();
        cdll.createCDLL(10);
        cdll.insertNode(2, 0);
        System.out.println(cdll.head.next.value);

    }
}
