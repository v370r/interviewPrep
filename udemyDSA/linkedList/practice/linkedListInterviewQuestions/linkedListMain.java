package udemyDSA.linkedList.practice.linkedListInterviewQuestions;

public class linkedListMain {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.createLL(2);
        ll.insertNode(3);
        ll.insertNode(4);
        ll.insertNode(5);
        ll.traversalLL();
    }

    public static LinkedList generateLL() {
        LinkedList ll = new LinkedList();
        ll.createLL(2);
        ll.insertNode(3);
        ll.insertNode(4);
        ll.insertNode(3);
        ll.insertNode(5);
        ll.insertNode(2);
        ll.insertNode(2);
        ll.insertNode(5);
        ll.insertNode(5);
        System.out.println("Generating linked list : ");
        ll.traverseLLSize();
        return ll;

    }

}
