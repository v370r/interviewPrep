package linkedList;

/*
 * Detect Loop in a linked List 
 */
class detectLoopInLLL {
    public static void main(String[] args) {
        LinkedList ll = getLoopedLinkedList(6);
        System.out.println("is loop detected ? " + detectLoop(ll));
    }

    public static boolean detectLoop(LinkedList ll) {
        Node fastNode = ll.head;
        Node slowNode = ll.head;
        int flag = 0;
        while ((slowNode != null) && (fastNode != null) && (fastNode.next != null)) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static LinkedList getLoopedLinkedList(int location) {
        LinkedList ll = new LinkedList();
        ll.insert(0);
        ll.insert(2);
        ll.insert(3);
        ll.insert(5);
        ll.insert(8);
        ll.insert(0);
        ll.insert(3);
        ll.insert(-2);
        ll.insert(1);
        ll.insert(3);
        Node tempNode = ll.head;
        for (int i = 0; i < location; i++) {
            tempNode = tempNode.next;
        }
        System.out.println("Cycle is made at location " + location + " node value " + tempNode.value);
        ll.tail.next = tempNode;
        return ll;
    }
}

/**
 * detectPointOfCylceLinkedList
 * using flyod cycle algorithm
 * since fast header covers as per pic
 * 2(x + a(y+z) + y) = x + b(y+z) + y
 * ==>x = (b-2a-1)(y+z) + z
 * ==> x = constat +z (b-2a-1) cycles rotated
 * x = z
 */
class detectPointOfCylceLinkedList {
    public static void main(String[] args) {
        LinkedList ll = detectLoopInLLL.getLoopedLinkedList(3);
        System.out.println(detectStartOfCycle(ll));

    }

    private static int detectStartOfCycle(LinkedList ll) {
        Node node = detectLoop(ll);
        Node tempNode = ll.head;
        while (node != tempNode) {
            node = node.next;
            tempNode = tempNode.next;
        }
        return tempNode.value;
    }

    public static Node detectLoop(LinkedList ll) {
        Node node = null;
        Node fastNode = ll.head;
        Node slowNode = ll.head;
        int flag = 0;
        while ((slowNode != null) && (fastNode != null) && (fastNode.next != null)) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                flag = 1;
                node = slowNode;
                break;
            }
        }
        if (flag == 1) {
            return node;
        } else {
            return node;
        }
    }

}

/**
 * detectAndRemoveLoopInLL
 */
class detectAndRemoveLoopInLL {
    public static void main(String[] args) {
        LinkedList ll = detectLoopInLLL.getLoopedLinkedList(5);
        detectAndRemoveOfCycle(ll);
    }

    private static void detectAndRemoveOfCycle(LinkedList ll) {
        Node intersection = detectPointOfCylceLinkedList.detectLoop(ll);
        deleteLoopLinkedList(ll, intersection);
    }

    private static void deleteLoopLinkedList(LinkedList ll, Node fast) {
        Node slowNode = ll.head; // if they interset at head level
        /* If loop exists */
        if (slowNode != fast) {
            while (slowNode.next != fast.next) {
                slowNode = slowNode.next;
                fast = fast.next;
            }
            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */
        }
        /* This case is added if fast and slow pointer meet at first position. */
        else {
            while (fast.next != slowNode) {
                fast = fast.next;
            }
            fast.next = null;
        }
        ll.traverse();

    }
}
