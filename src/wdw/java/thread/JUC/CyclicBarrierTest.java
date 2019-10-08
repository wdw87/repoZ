package wdw.java.thread.JUC;

import java.util.Random;
import java.util.concurrent.*;

class Processor implements Runnable {
    private static Random rand = new Random(47);
    private final CyclicBarrier barrier;

    Processor(CyclicBarrier b) {
        barrier = b;
    }

    public void process() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(1000));
        System.out.println("Thread: " + Thread.currentThread().getName() + " processed completed");
    }

    public void send() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        System.out.println("Thread: " + Thread.currentThread().getName() + " send completed");
    }

    @Override
    public void run() {
        try {
            process();
            barrier.await();
            send();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

public class CyclicBarrierTest {
    final static int SIZE = 10;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(SIZE, () -> {
            System.out.println("All data processed,Data check completed,Sending....");
        });
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new Processor(cyclicBarrier));
        }
        exec.shutdown();
    }

}
