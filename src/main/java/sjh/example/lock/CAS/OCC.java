package sjh.example.lock.CAS;

import java.util.concurrent.atomic.AtomicInteger;

public class OCC {
    // Optimistic Concurrency Control
    // WRONG
    private static int num;

    private static AtomicInteger num2 = new AtomicInteger(0);

    public static void main(String[] args) {
//        // 错误写法
//        for (int i = 0; i < 3; ++i) {
//            Thread t = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    while (num < 1000) {
//                        System.out.printf("ThreadName: %s, num = %d\n", Thread.currentThread().getName(), num++);
//                    }
//                }
//            });
//            t.start();
//        }

//        // 悲观锁
//        for (int i = 0; i < 3; ++i) {
//            Thread t = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    synchronized (OCC.class) {
//                        while (num < 1000) {
//                            System.out.printf("ThreadName: %s, num = %d\n", Thread.currentThread().getName(), num++);
//                        }
//                    }
//                }
//            });
//            t.start();
//        }

        // 乐观锁，通过 AtomicInteger 使用底层 CAS 机制
        for (int i = 0; i < 3; ++i) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (num2.get() < 1000) {
                        System.out.printf("ThreadName: %s, num = %d\n", Thread.currentThread().getName(), num2.incrementAndGet());
                    }
                }
            });
            t.start();
        }
    }
}
