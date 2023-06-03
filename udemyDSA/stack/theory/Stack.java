package udemyDSA.stack.theory;

public class Stack {
    int[] arr;
    int topOfStack;

    public Stack(int size) {
        arr = new int[size];
        topOfStack = -1;
        System.out.println("The Stack is created with size of " + size);
    }

    public boolean isEmpty() {
        if (topOfStack == -1) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isFull() {
        if (topOfStack == arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("This Stack is full !");
        } else {
            arr[topOfStack + 1] = value;
            topOfStack++;
            System.out.println("The value is successfully inserted");
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty!");
            return -1;
        } else {
            int topStack = arr[this.topOfStack];
            topOfStack--;
            return topStack;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty !");
            return -1;
        } else {
            return arr[this.topOfStack];
        }
    }

    public void deleteStack() {
        arr = null;
        System.out.println("The stack has been deleted successfully;");
    }
}
