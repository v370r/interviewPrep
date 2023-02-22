package udemyDSA.queue.theory;

public class queueMain {
    public static void main(String[] args) {
        QueueArray queue = new QueueArray(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        int result = queue.dequeue();
        System.out.println(result);
        result = queue.dequeue();
        System.out.println(result);
        result = queue.dequeue();
        System.out.println(result);
        result = queue.dequeue();
        System.out.println(result);
    }
}
