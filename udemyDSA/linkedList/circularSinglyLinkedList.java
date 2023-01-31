package udemyDSA.linkedList;

public class circularSinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createcircularSinglyLinkedList(int value) {
        Node node = new Node();
        head = node;
        tail = node; // note: no tail.next when only 1 element
        node.value = value;
        size = 1;
        return head;
    }

    public void insertcircularSinglyLinkedList(int location, int value) {
        Node node = new Node();
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
}
