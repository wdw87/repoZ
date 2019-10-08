package wdw.java.thread;

class A extends  Thread{
    @Override
    public void run() {
        System.out.println("A running");
    }
}
class B extends Thread{
    private A a;
    public B(A a){
        this.a = a;
    }
    @Override
    public void run() {
        try {
            a.join();
            System.out.println("B running");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class JoinTest {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }
}
