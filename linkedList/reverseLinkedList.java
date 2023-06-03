package linkedList;

public class reverseLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.traverse();
        System.out.println();
        reverseLinkedList(ll);
    }

    /*
     * Needs 3 pointers curr, next, prev
     */
    private static void reverseLinkedList(LinkedList ll) {
        Node curr = ll.head;
        Node prev = null;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ll.head = prev;
        ll.traverse();
    }

}
