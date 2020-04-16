package wdw.os.concurrent.a使用线程;

public class ExtendThread extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Thread run");
    }

    public static void main(String[] args) {
        ExtendThread extendThread = new ExtendThread();
        extendThread.setName("thread test");
        extendThread.start();
    }
}
