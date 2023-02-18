package udemyDSA.linkedList.practice.linkedListInterviewQuestions;

/*
 * Given two singly LinkedLists , determine if the two linkedLists intersect. Return the intersecting Node.
 * Note: intersections are defined based on references not values;
 * Kth node of first linkedList is the exact node by reference as the jth node of the second linked list , then they are intersecting
 */
public class intersectionOfLinkedLists {

    public static void main(String[] args) {
        LinkedList lla = new LinkedList();
        lla.insertNode(3);
        lla.insertNode(1);
        lla.insertNode(5);
        lla.insertNode(9);
        LinkedList llb = new LinkedList();
        llb.insertNode(2);
        llb.insertNode(4);
        llb.insertNode(6);
        addSameNode(lla, llb, 7);
        addSameNode(lla, llb, 2);
        addSameNode(lla, llb, 2);
        Node intersectionPoint = intersection(lla, llb);
        System.out.println("Intersection point ->" + intersectionPoint.value);

    }

    /*
     * If we notice size difference remove the size difference
     * from longer sized linked list and do loop to find the node
     */
    public static Node intersection(LinkedList lis1, LinkedList lis2) {
        if (lis1.head == null | lis2.head == null) {
            return null;
        }
        if (lis1.tail != lis2.tail) {
            System.out.println("No intersection found");
            return null;
        }
        Node shorter = new Node();
        Node longer = new Node();
        longer = lis1.size > lis2.size ? lis1.head : lis2.head;
        shorter = lis1.size < lis2.size ? lis1.head : lis2.head;

        longer = getKthNode(longer, Math.abs(lis1.size - lis2.size));
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        return longer;
    }

    public static Node getKthNode(Node head, int k) {
        Node curr = head;
        while (k > 0 && curr != null) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    static void addSameNode(LinkedList lla, LinkedList llb, int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        lla.tail.next = newNode;
        lla.tail = newNode;
        llb.tail.next = newNode;
        llb.tail = newNode;
    }

}
