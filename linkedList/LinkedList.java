package linkedList;

public class LinkedList {
    Node head;
    Node tail;
    int size;

    public void insert(int nodeValue) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            head = node;
            tail = node;
            tail.next = null;
            size = 1;
        } else {
            tail.next = node;
            tail = node;
            tail.next = null;
            size++;
        }
    }

    public void traverse() {
        if (head == null) {
            System.out.println("The LinkedList doesnt exist");
        } else {
            Node tempNode = head;
            while (tempNode != null) {
                if (tempNode.next != null) {
                    System.out.print(tempNode.value + "-> ");
                } else {
                    System.out.print(tempNode.value);
                }
                tempNode = tempNode.next;
            }
        }
    }
}
