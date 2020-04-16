package wdw.os.concurrent.a使用线程;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ImplementCallable implements java.util.concurrent.Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ": Thread run");
        return 55;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ImplementCallable callable = new ImplementCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask, "test callable");
        thread.start();
        System.out.println(futureTask.get());
    }
}
