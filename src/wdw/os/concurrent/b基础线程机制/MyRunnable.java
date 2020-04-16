package wdw.os.concurrent.b基础线程机制;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run...");
    }
}
