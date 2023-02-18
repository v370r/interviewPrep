package udemyDSA.linkedList.practice.linkedListInterviewQuestions;

/*
 * Add two numbers represented by LinkedList, where each node contains a single digit,
 * solution must be stored in reverse order , such that 1's digit is the head of the list . 
 * Lis1 = 7->1->6 
 * lis2 = 5->9->2 
 *  Res ----- 617+295 = 912 ===> 2 -> 1 -> 9 
 */
public class sumLinkedList {
    public static void main(String[] args) {
        LinkedList lla = new LinkedList();
        lla.createLL(7);
        lla.insertNode(1);
        lla.insertNode(6);
        LinkedList llb = new LinkedList();
        llb.createLL(5);
        llb.insertNode(9);
        llb.insertNode(2);
        llb.insertNode(1);
        LinkedList llc = sumLists(lla, llb);
        llc.traversalLL();

    }

    public static LinkedList sumLists(LinkedList lla, LinkedList llb) {
        Node n1 = lla.head;
        Node n2 = llb.head;
        int carry = 0;
        LinkedList res = new LinkedList();
        while (n1 != null || n2 != null) {
            int result = carry;
            if (n1 != null) {
                result += n1.value;
                n1 = n1.next;
            }
            if (n2 != null) {
                result += n2.value;
                n2 = n2.next;
            }
            res.insertNode(result % 10);
            carry = result / 10;
        }
        return res;
    }
}
