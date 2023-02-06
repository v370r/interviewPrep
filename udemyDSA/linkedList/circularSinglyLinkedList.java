package udemyDSA.linkedList;

public class circularSinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createcircularSinglyLinkedList(final int value) {
        final Node node = new Node();
        head = node;
        tail = node; // note: no tail.next when only 1 element
        node.value = value;
        size = 1;
        return head;
    }

    public void insertcircularSinglyLinkedList(final int location, final int value) {
        final Node node = new Node();
        node.value = value;
        if (head == null) {
            createcircularSinglyLinkedList(value);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
            tail.next = node;
            size++;

        } else if (location >= size) {
            tail.next = node;
            tail = node;
            tail.next = head;

        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index += 1;
            }
            node.next = tempNode.next;
            tempNode.next = node;
        }
        size++;
        return;
    }

    /*
     * Without use of size
     */
    public void travesecircularSinglyLinkedListWithOutSize() {
        if (head != null) {
            Node tempNode = head;
            System.out.print(tempNode.value);
            tempNode = tempNode.next;
            System.out.print(" -> ");
            while (tempNode != head) { // bad idea to use
                System.out.print(tempNode.value);
                if (tempNode.next != head) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        }
    }

    public void traverseCSLL() {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
            System.out.println("\n");
        } else {
            System.out.println("\n  CSLL doesnt exist");
        }
    }

    public int getSize() {
        return this.size;
    }

    public boolean searchNode(final int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found  node at location " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node doesn't exist in this circular linked list");
        return false;
    }

    public void deleteNode(final int location) {
        if (head == null) {
            System.out.println(" the CSLL doesn't exist");
            return;
        } else if (location == 0) {
            head = head.next;
            tail.next = head;
            size--;
            if (size == 0) {
                tail = null;
                head.next = null;
                head = null;
            }
        } else if (location >= size) {
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head) {
                head.next = null;
                head = null;
                size--;
                return;
            }
            tempNode.next = head;
            tail = tempNode;
            size--;
        } else {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
        }
    }

    public void deleteCSLL() {
        if (head == null) {
            System.out.println("the CSLL doesnt exist");
        } else {
            head = null;
            tail.next = null;
            tail = null;
            System.out.println("the csll has been deleted successfully");
        }
    }
}
