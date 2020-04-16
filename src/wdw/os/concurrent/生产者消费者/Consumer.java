package wdw.os.concurrent.生产者消费者;

import wdw.os.concurrent.生产者消费者.useAwait.BufferUsingAwait;

public class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(true){
            try {
                buffer.consume();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
