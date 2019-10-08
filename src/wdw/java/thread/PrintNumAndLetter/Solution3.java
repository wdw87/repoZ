package wdw.java.thread.PrintNumAndLetter;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution3 {
    private volatile ThreadToGO threadToGO = new ThreadToGO();

    class ThreadToGO {
        int status = 1;
    }

    class NumPrinter implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i < 52; i += 2) {
                while (threadToGO.status != 1) {
                }
                for (int j = 0; j < 2; j++) {
                    System.out.println(i + j);
                }
                threadToGO.status = 2;
            }
        }
    }

    class LetterPrinter implements Runnable {
        @Override
        public void run() {
            for (char c = 'A'; c <= 'Z'; c++) {
                while (threadToGO.status != 2) {
                }
                System.out.println(c);
                threadToGO.status = 1;
            }
        }
    }

    public Solution3() {
        NumPrinter np = new NumPrinter();
        LetterPrinter lp = new LetterPrinter();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(np);
        exec.execute(lp);
        exec.shutdown();
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
    }
}
