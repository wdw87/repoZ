package wdw.java.thread.JUC;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample {
    private static Random  rand = new Random(47);
    public static void main(String[] args) {
        final int clientCount = 3;
        final int totalRequestCount = 10;
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i< totalRequestCount; i++){
            exec.execute(()->{
                try {
                    semaphore.acquire();
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(1000));
                    System.out.print(semaphore.availablePermits() + " ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            });
        }
        exec.shutdown();
    }
}
