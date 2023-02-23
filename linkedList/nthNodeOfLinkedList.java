package linkedList;

/*
 * Find the nth Node from the End
 */
class nthNodeOfEndLinkedList {
    public static void main(String[] args) {
        LinkedList ll = getLinkedList();
        ll.traverse();
        System.out.println();
        int location = 3;
        System.out.println(nthNodeFromEnd(ll.head, location));

    }

    private static int nthNodeFromEnd(Node head, int location) {
        Node tempNode = head;
        Node ahead = head;
        for (int i = 0; i < location; i++) {
            ahead = ahead.next;
        }
        while (ahead.next != null) {
            ahead = ahead.next;
            tempNode = tempNode.next;
        }
        return tempNode.value;
    }

    private static LinkedList getLinkedList() {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(5);
        ll.insert(5);
        ll.insert(2);
        return ll;
    }

}
