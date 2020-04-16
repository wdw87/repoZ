package wdw.os.concurrent.a使用线程;

public class ImplementRunnable implements java.lang.Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Thread run");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ImplementRunnable(), "test runnable");
        thread.start();
    }
}
