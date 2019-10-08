package wdw.java.thread.JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyCall implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        return 23;
    }
}
public class CallableTest {
    public static void main(String[] args) throws Exception{
        MyCall mc = new MyCall();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }
}
