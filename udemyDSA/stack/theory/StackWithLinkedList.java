package udemyDSA.stack.theory;

import udemyDSA.linkedList.theory.Node;
import udemyDSA.linkedList.theory.singleLinkedList;

public class StackWithLinkedList {
    singleLinkedList linkedList;

    public StackWithLinkedList() {
        linkedList = new singleLinkedList();
    }

    // push method
    public void push(int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = linkedList.head;
        linkedList.head = newNode;
        linkedList.size++;
        linkedList.traverseSingleLinkedList();

    }

    public boolean isEmpty() {
        if (linkedList.head == null) {
            return true;
        } else {
            return false;
        }
    }

    public int pop() {
        int result = -1;
        if (isEmpty()) {
            System.out.println("The stack is Empty !");

        } else {
            result = linkedList.head.value;
            linkedList.deletionOfNode(0); // delete first node
        }
        return result;
    }

    public int peek() {
        int result = -1;
        if (isEmpty()) {
            System.out.println("The stack is Empty !");

        } else {
            result = linkedList.head.value;
        }
        return result;
    }

    public void deleteStack() {
        linkedList.head = null;
        System.out.println("The stack has been deleted");
    }
}
