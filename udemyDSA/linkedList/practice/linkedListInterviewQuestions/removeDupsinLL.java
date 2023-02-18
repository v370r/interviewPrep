package udemyDSA.linkedList.practice.linkedListInterviewQuestions;

import java.util.*;

public class removeDupsinLL {
    public static void main(String[] args) {
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
        // ll.createLL(1);
        // ll.insertNode(2);
        // ll.insertNode(1);
        // ll.insertNode(3);
        ll.traverseLLSize();
        // removeDupsMySolution(ll.head);
        // ll.traversalLL();

        removeDupsSolution(ll);
        ll.traverseLLSize();
    }

    private static void removeDupsSolution(LinkedList ll) {
        HashSet<Integer> hs = new HashSet<>();
        Node current = ll.head;
        Node prev = null;
        while (current != null) {
            int curr_val = current.value;
            if (hs.contains(curr_val)) {
                prev.next = current.next;
                ll.size--;
            } else {
                hs.add(curr_val);
                prev = current;

            }
            current = current.next;

        }
    }

    private static void removeDupsMySolution(Node head) {
        List<Integer> lis = new ArrayList<>();
        Node tempNode = head;
        while ((tempNode.next != null) && (tempNode.next.next != null)) {
            lis.add(tempNode.value);
            if (lis.contains(tempNode.next.value)) {
                tempNode.next = tempNode.next.next;
            } else {
                tempNode = tempNode.next;
            }
        }
        // Now remove last duplicate
        if (lis.contains(tempNode.next.value)) {
            tempNode.next = null;
        }

    }
}
