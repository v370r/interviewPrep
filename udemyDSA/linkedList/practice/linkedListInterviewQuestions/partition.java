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
                Node newNode = new Node();
                newNode.value = tempNode.value;
                newNode.next = res.head;
                res.head = newNode;
                res.size = res.size + 1;
            } else {
                // Node newNode = new Node();
                // newNode.value = tempNode.value;
                // tail.next = newNode;
                // tail = newNode;
                res.insertNode(tempNode.value);

            }
        }
        res.traverseLLSize();

    }

    // public static void addLeftSide(Node head, int value) {
    // Node newNode = new Node();
    // newNode.value = value;
    // newNode.next = head;
    // head = newNode;
    // }

    // public static void addRightSide(Node tail, int value) {
    // Node newNode = new Node();
    // newNode.value = value;
    // tail.next = newNode;
    // tail = newNode;
    // }
}
