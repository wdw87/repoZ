package wdw.java.thread.PrintNumAndLetter;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution4 {
    private AtomicInteger threadToGO = new AtomicInteger(1);

    class NumPrinter implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i < 52; i += 2) {
                while (threadToGO.get() != 1) {
                }
                for (int j = 0; j < 2; j++) {
                    System.out.println(i + j);
                }
                threadToGO.set(2);
            }
        }
    }

    class LetterPrinter implements Runnable {
        @Override
        public void run() {
            for (char c = 'A'; c <= 'Z'; c++) {
                while (threadToGO.get() != 2) {
                }
                System.out.println(c);
                threadToGO.set(1);
            }
        }
    }

    public Solution4() {
        NumPrinter np = new NumPrinter();
        LetterPrinter lp = new LetterPrinter();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(np);
        exec.execute(lp);
        exec.shutdown();
    }

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
    }
}
