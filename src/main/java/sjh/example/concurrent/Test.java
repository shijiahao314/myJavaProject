package sjh.example.concurrent;

import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        // deadlock
        deadLock();
    }

    private static void deadLock() throws InterruptedException {
        Object object1 = new Object();
        Object object2 = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (object1) {
                System.out.println(Thread.currentThread() + "get resource 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (object2) {
                    System.out.println(Thread.currentThread() + "get resource 2");
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (object2) {
                System.out.println(Thread.currentThread() + "get resource 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (object1) {
                    System.out.println(Thread.currentThread() + "get resource 1");
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.wait();
        thread2.wait();
        System.out.println("finish");
    }
}
