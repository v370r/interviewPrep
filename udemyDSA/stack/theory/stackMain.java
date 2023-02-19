package udemyDSA.stack.theory;

class stackMain {
    public static void main(String[] args) {
        Stack newStack = new Stack(4);
        System.out.println("Is Empty? :" + newStack.isEmpty());
        newStack.push(1);
        newStack.push(2);
        newStack.push(3);
        newStack.push(4);
        System.out.println("Pop " + newStack.pop());
        System.out.println("Peek " + newStack.peek());

    }
}

class stackLinkedList {
    public static void main(String[] args) {
        StackWithLinkedList sLL = new StackWithLinkedList();
        sLL.push(5);
        sLL.push(10);
        sLL.push(1);
        sLL.push(0);
        sLL.push(6);
        System.out.println("is Empty " + sLL.isEmpty());
        System.out.println("Pop " + sLL.pop());
        sLL.push(1);
    }
}