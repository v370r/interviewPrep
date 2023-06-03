package linkedList;

public class deleteNode {
    public static void main(String[] args) {
        LinkedList ll = generateLL();
        int location = 3;
        Node tempNode = ll.head;
        ll.traverse();
        for (int i = 0; i < location; i++) {
            tempNode = tempNode.next;
        }
        deleteGivenNode(tempNode);
        ll.traverse();
    }

    private static void deleteGivenNode(Node tempNode) {
        System.out.println("Deleting this node : " + tempNode.value);
        Node curr_ = tempNode;
        curr_.value = curr_.next.value;
        curr_.next = curr_.next.next;

    }

    private static LinkedList generateLL() {
        LinkedList ll = new LinkedList();
        ll.insert(10);
        ll.insert(2);
        ll.insert(4);
        ll.insert(3);
        ll.insert(5);
        ll.insert(2);
        ll.insert(8);
        return ll;
    }
}
