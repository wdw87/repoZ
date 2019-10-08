package wdw.java.thread;

class MyThread1 extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Thread run");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println("Thread finished");
        }
    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        while(!interrupted()){
            //...
        }
        System.out.println("Thread interrupted");
    }
}
public class InterruptTest {
    public static void main(String[] args) {
        MyThread2 thread1 = new MyThread2();
        thread1.start();
        thread1.interrupt();
        System.out.println("Main run");
    }
}
