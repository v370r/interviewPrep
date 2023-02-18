package udemyDSA.linkedList.practice.linkedListInterviewQuestions;

public class nthLastValue {
    public static void main(String[] args) {
        LinkedList ll = linkedListMain.generateLL();
        int location = 4;
        System.out.println("Nth last value is :" + nthLastValueMySolution(ll, location));

    }

    private static int nthLastValueMySolution(LinkedList ll, int location) {
        Node aheadNode = ll.head;
        Node behindNode = ll.head;
        for (int i = 0; i < location - 1; i++) {
            if (aheadNode != null) {
                aheadNode = aheadNode.next;
            } else {
                System.out.println("inVlaid location");
            }

        }

        while (aheadNode.next != null) {
            behindNode = behindNode.next;
            aheadNode = aheadNode.next;
        }
        return behindNode.value;
    }
}
