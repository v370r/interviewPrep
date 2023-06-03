package linkedList;

public class intersectionInYlinkedList {
    public static void main(String[] args) {
        LinkedList ll1 = getLinkedList1();
        LinkedList ll2 = getLinkedList2();
        int location = 4;
        Node tempNode = ll2.head;
        for (int i = 0; i < location; i++) {
            tempNode = tempNode.next;
        }
        System.out.println("Creating interjection at node :" + tempNode.value);
        Node tempNode2 = ll1.head;
        while (tempNode2.next != null) {
            tempNode2 = tempNode2.next;
        }
        tempNode2.next = tempNode;
        ll1.traverse();
        System.out.println();
        ll2.traverse();

        // findInterJectionNode(ll1, ll2);
        findInterWithNode(ll1.head, ll2.head);
    }

    private static void findInterWithNode(Node headA, Node headB) {
        int len1 = 0, len2 = 0;
        Node n1 = headA;
        Node n2 = headB;

        while (n1.next != null) {
            n1 = n1.next;
            len1++;
        }

        while (n2.next != null) {
            n2 = n2.next;
            len2++;
        }
        Node rot;
        if (len1 > len2) {
            rot = headA;
        } else {
            rot = headB;
        }

        for (int i = 0; i < Math.abs(len1 - len2) - 1; i++) {
            System.out.println("Final interjection :" + rot.value);
            rot = rot.next;
        }
        System.out.println(rot.value);
    }

    private static void findInterJectionNode(LinkedList ll1, LinkedList ll2) {
        int length1 = 0, length2 = 0;
        Node n1 = ll1.head;
        Node n2 = ll2.head;
        while (n1.next != null) {
            n1 = n1.next;
            length1++;
        }
        while (n2.next != null) {
            n2 = n2.next;
            length2++;
        }
        Node looped;
        if (length1 > length2) {
            looped = ll1.head;
        } else {
            looped = ll2.head;
        }

        for (int i = 0; i < Math.abs(length1 - length2) - 1; i++) {
            looped = looped.next;
        }
        System.out.println("Final interjection :" + looped.value);
    }

    private static LinkedList getLinkedList2() {
        LinkedList ll2 = new LinkedList();
        ll2.insert(2);
        ll2.insert(-2);
        ll2.insert(4);
        ll2.insert(2);
        ll2.insert(4);
        ll2.insert(9);
        ll2.insert(-2);
        ll2.insert(3);
        ll2.insert(5);
        ll2.insert(6);
        ll2.insert(42);
        ll2.insert(90);
        return ll2;
    }

    private static LinkedList getLinkedList1() {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(3);
        ll.insert(4);
        ll.insert(6);
        ll.insert(2);
        ll.insert(6);
        ll.insert(2);
        return ll;
    }
}
