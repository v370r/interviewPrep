package udemyDSA.linkedList.theory;

public class circularDoublyLinkedList {
    public DoublyNode head;
    public DoublyNode tail;
    public int size;

    // create DLL
    public DoublyNode createCDLL(int nodeValue) {
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        newNode.next = newNode;
        newNode.prev = newNode;
        size = 1;
        return head;
    }

    // Insertion Method
    public void insertNode(int nodeValue, int location) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if (head == null) {
            createCDLL(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        } else if (location >= size) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            tail = newNode;
        } else {
            DoublyNode tempNode = new DoublyNode();
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.prev = newNode;

        }
        size++;
    }

    /*
     * Other like traverse and reverse traverse are same :)
     */

    /*
     * Deletion of node
     */
    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("The CDLL doesn't exist");
            return;
        } else if (location == 0) {
            if (size == 1) {
                head.prev = null;
                head.next = null;
                size--;
                return;
            } else {
                head = head.next;
                head.prev = tail;
                tail.next = head;
                size--;
                return;
            }
        } else if (location >= size) {
            if (size == 1) {
                head.prev = null;
                head.next = null;
                size--;
                return;
            } else {
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
                size--;
            }
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }
        return;
    }

    /*
     * Delete entire CDLL
     */
    public void deleteCDLL() {
        DoublyNode tempNode = head;
        for (int i = 0; i < size; i++) {
            tempNode.prev = null;
            tempNode = tempNode.next;
        }
        head = null;
        tail = null;
        System.out.println("The cdll has been deleted!");
    }
}
