package linkedList;

public class middleElementOfLinkedLisst {
    public static void main(String[] args) {
        LinkedList ll = createLL();
        middleElement(ll);
    }

    public static void middleElement(LinkedList ll) {
        Node ahead = ll.head;
        Node curr = ll.head;
        while ((ahead.next != null) && (ahead.next.next != null) && (curr.next != null)) {
            ahead = ahead.next.next;
            curr = curr.next;
        }
        System.out.println(curr.value);

    }

    private static LinkedList createLL() {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        ll.traverse();
        System.out.println();
        return ll;
    }
}
