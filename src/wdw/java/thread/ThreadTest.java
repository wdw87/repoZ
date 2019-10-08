package wdw.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyRunnable implements Runnable{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public MyRunnable(){}
    public MyRunnable(int countDown){
        this.countDown = countDown;
    }
    public String status(){
        return id + "->" + countDown;
    }
    @Override
    public void run() {
        try {
            while(countDown-- > 0){
                System.out.println(status());
                //Thread.yield();
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}

public class ThreadTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; ++i){
            executorService.execute(new MyRunnable());
            //new Thread(new MyRunnable()).start();
        }
        executorService.shutdown();
        System.out.println("Thread started!");
    }
}
