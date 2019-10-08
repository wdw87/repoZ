package wdw.java.thread.PrintNumAndLetter;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Solution2 {
    private final ThreadToGO threadToGO = new ThreadToGO();
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    class ThreadToGO {
        int status = 1;
    }

    class NumPrinter implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 52; i += 2) {
                try {
                    lock.lock();
                    while (threadToGO.status != 1) {
                        condition.await();
                    }
                    for (int j = 0; j < 2; j++) {
                        System.out.println(i + j);
                    }
                    threadToGO.status = 2;
                    condition.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class LetterPrinter implements Runnable {
        @Override
        public void run() {
            for (char c = 'A'; c <= 'Z'; c++) {
                try {
                    lock.lock();
                    while (threadToGO.status != 2) {
                        condition.await();
                    }
                    System.out.println(c);
                    threadToGO.status = 1;
                    condition.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public Solution2() {
        NumPrinter np = new NumPrinter();
        LetterPrinter lp = new LetterPrinter();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(np);
        exec.execute(lp);
        exec.shutdown();
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
    }
}
