package arrays.Sorting_Searching.sorting;

public class BinaryHeap {
    int[] arr;
    int sizeOfTree;

    public BinaryHeap(int size) {
        arr = new int[size + 1];
        this.sizeOfTree = 0;
        System.out.println("Empty heap has been created");

    }

    public int sizeOfTree() {
        System.out.println("Size of Tree : " + sizeOfTree);
        return sizeOfTree;
    }

    public int sizeOfArray() {
        return arr.length;
    }

    public boolean isHeapEmpty() {
        if (sizeOfTree <= 0) {
            System.out.println("The tree is empty !");
            return true;
        } else {
            System.out.println("Tree is not empty :)");
            return false;
        }
    }

    public void deleteHeap() {
        arr = null;
        System.out.println("Heap has been deleted !");

    }

    public void insertinHeap(int value) {
        System.out.println("Inserting " + value + "in Heap ....");
        arr[sizeOfTree + 1] = value;
        sizeOfTree++;
        HeapifyBottomToTop(sizeOfTree);
        System.out.println("Inserted " + value + " successfully in heap !");
        levelOrder();
    }

    public void peek() {
        if (sizeOfTree == 0) {
            System.out.println("Heap is empty !");
        } else {
            System.out.println("Head of heap is : " + arr[1]);
        }
    }

    public int extractHeadofHeap() {
        if (sizeOfTree == 0) {
            System.out.println("Head is empty !");
            return -1;
        } else {
            System.out.println("head of the head is : " + arr[1]);
            int extractedValue = arr[1];
            arr[1] = arr[sizeOfTree];
            sizeOfTree--;
            HeapifyTopToBottom(1);
            System.out.println("Successfully extraced value from Heap.");
            levelOrder();
            return extractedValue;
        }
    }

    public void HeapifyBottomToTop(int index) {
        int parent = index / 2;
        if (index <= 1) {
            return;
        }
        if (arr[index] < arr[parent]) {
            int tmp = arr[index];
            arr[index] = arr[parent];
            arr[parent] = tmp;
        }
        HeapifyBottomToTop(parent);
    }

    public void HeapifyTopToBottom(int index) {
        int left = index * 2;
        int right = (index * 2) + 1;
        int smallestChild = 0;
        if (sizeOfTree < left) {
            return;
        } else if (sizeOfTree == left) {
            if (arr[index] > arr[left]) {
                int tmp = arr[index];
                arr[index] = arr[left];
                arr[left] = tmp;
            }
            return;
        } else {
            if (arr[left] < arr[right]) {
                smallestChild = left;
            } else {
                smallestChild = right;
            }
            if (arr[index] > arr[smallestChild]) {
                int tmp = arr[index];
                arr[index] = arr[smallestChild];
                arr[smallestChild] = tmp;
            }
        }
        HeapifyTopToBottom(smallestChild);
    }

    public void levelOrder() {
        System.out.println("Printing all the elements of this heap ...");
        for (int i = 1; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println("\n");
    }
}
