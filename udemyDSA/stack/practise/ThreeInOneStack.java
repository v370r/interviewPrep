package udemyDSA.stack.practise;

public class ThreeInOneStack {
    private int numberOfStack = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public ThreeInOneStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStack];
        sizes = new int[numberOfStack];
    }

    // isFull
    public boolean isFull(int stackNumber) {
        if (sizes[stackNumber] == stackCapacity) {
            return true;
        }
        return false;
    }

    // Empty
    public boolean isEmpty(int stackNumber) {
        if (sizes[stackNumber] == 0) {
            return true;
        }
        return false;
    }

    private int indexOfTop(int stackNumber) {
        int offset = stackNumber * stackCapacity;
        int size = sizes[stackNumber];
        return offset + size - 1;
    }

    public void push(int stackNumber, int value) {
        if (isFull(stackNumber)) {
            System.out.println("The stack is full ");
        } else {
            sizes[stackNumber]++;
            values[indexOfTop(stackNumber)] = value;
        }
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("the stack is empty");
            return -1;
        } else {
            int topIndex = indexOfTop(stackNum);
            int value = values[topIndex];
            values[topIndex] = 0;
            sizes[stackNum]--;
            return value;
        }
    }

    // peek

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("the stack is empty");
            return -1;
        } else {
            int topIndex = indexOfTop(stackNum);
            int value = values[topIndex];
            return value;
        }
    }
}
