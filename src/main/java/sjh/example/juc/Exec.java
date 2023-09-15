package sjh.example.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Exec {

    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, workQueue);

        
        /*
        1.corePool
        2.workQueue
        3.maximumPool - corePool
        4.reject
         */
        for (int i = 0; i < 7; i++) {
            int finalI = i;
            executor.execute(() -> {
                Thread.currentThread().setName("Thread" + finalI);
                System.out.println("Task executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            System.out.println(executor.getActiveCount());
            System.out.println(workQueue);
        }
    }
}
