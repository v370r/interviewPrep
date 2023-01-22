package udemyDSA.linkedList.singleLinkedList;

public class singleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createSingleLinkedList(int value) {
        head = new Node();
        Node node = new Node();
        node.value = value;
        node.next = null;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertInLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createSingleLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node; // Dont forget to increase size
        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    // Traversal of Single Linked List
    public void traverseSingleLinkedList() {
        if (head == null) {
            System.out.println("Single LinkedList doesn`t exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }

    // search inside linked List
    public boolean searchNode(int nodeValue) {
        System.out.println("Search initiated for the value " + nodeValue);
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node at location. " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    /*
     * Deletion of Node in sLL
     * 1. Deleting the first Node
     * 2. Deleting any given node
     * 3. Deleting the last Node
     */
    public void deletionOfNode(int location) {
        System.out.println("Deletion initiated for the location " + location);
        if (head == null) {
            System.out.println("The sLL does not exist");
            return;
        } else if (location == 0) {
            head = head.next; // if single head will be null
            size--;
            if (size == 0) {
                tail = null;
            }
        } else if (location >= size) {
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) { // last but one
                tempNode = tempNode.next;
            }
            if (tempNode == head) { // if only one element
                tail = head = null;
                size--;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        } else {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) { // last but one
                tempNode = tempNode.next;
            }
            System.out.println("Value found " + tempNode.next.value + " initializing deletion");
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    /*
     * Delete entire single Linked List
     * Note: Garbage collector will delete all nodes if it was not referencing
     * i.e.. if head m-> null all values except last node will be collected by
     * garbage collector so need to refer tail to null too
     */
    public void deleteSingleLinkedList() {
        head = null;
        tail = null;
        System.out.println("Single linked list is deleted successfully");
    }
}
