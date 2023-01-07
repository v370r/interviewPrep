package fundamentals.threading;

public class threadingFund {
    public static void main(String[] args) {

    }

}

// -----------------------------------------
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread"); // Thread job
        }
    }
}

class ThreadDemo {
    public static void main(String[] args) {
        MyThread t = new MyThread();// Instantiation of a Thread
        t.start();// starting of a Thread

        for (int i = 0; i < 5; i++) {
            System.out.println("main thread");
        }
    }
}

// --------------------------------------

/*
 * Using runnable intrface
 * check for notes to see different cases
 */

class myRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Child thread");
        }
    }
}

class ThreadDemoRunnable {
    public static void main(String[] args) {
        myRunnable r = new myRunnable();
        Thread t = new Thread(r);
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("main thread");
        }

    }
}