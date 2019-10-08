package wdw.java.thread.PrintNumAndLetter;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution1 {
    private final ThreadToGO threadToGO = new ThreadToGO();

    class ThreadToGO {
        int status = 1;
    }

    class NumPrinter implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 1; i < 52; i+=2 ) {
                    synchronized (threadToGO){
                        while (threadToGO.status != 1) {
                            threadToGO.wait();
                        }
                        for(int j = 0; j <2; j++){
                            System.out.println(i + j);
                        }
                        threadToGO.status = 2;
                        threadToGO.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class LetterPrinter implements Runnable{
        @Override
        public void run() {
            try {
                for(char c = 'A'; c <='Z'; c++){
                    synchronized (threadToGO){
                        while(threadToGO.status != 2){
                            threadToGO.wait();
                        }
                        System.out.println(c);
                        threadToGO.status = 1;
                        threadToGO.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public Solution1(){
        NumPrinter np = new NumPrinter();
        LetterPrinter lp = new LetterPrinter();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(np);
        exec.execute(lp);
        exec.shutdown();
    }
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
    }
}
