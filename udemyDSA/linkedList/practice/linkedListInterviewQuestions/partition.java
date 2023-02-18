package udemyDSA.linkedList.practice.linkedListInterviewQuestions;

/*
 * Write code to partition a linked list around a value x. 
 * such that all nodes less than x comes before all nodes greater than or equals to x
 * 
 * // if less than node values add left side or else equal or more add right :)
 */
public class partition {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.createLL(11);
        ll.insertNode(3);
        ll.insertNode(9);
        ll.insertNode(10);
        ll.insertNode(15);
        int x = 10;
        ll.traverseLLSize();
        createPartition(ll, x);

    }

    private static void createPartition(LinkedList ll, int x) {
        Node tempNode = ll.head;
        LinkedList res = new LinkedList();
        res.createLL(ll.head.value);
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            if (tempNode.value < x) {
                addLeftSide(res, tempNode.value);
            } else {
                addRightSide(res, tempNode.value);
            }
        }
        res.traverseLLSize();

    }

    public static void addLeftSide(LinkedList ll, int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = ll.head;
        ll.head = newNode;
        ll.size = ll.size + 1;
    }

    public static void addRightSide(LinkedList ll, int value) {
        Node newNode = new Node();
        newNode.next = null;
        newNode.value = value;
        ll.tail.next = newNode;
        ll.tail = newNode;
        ll.size = ll.size + 1;
    }
}
