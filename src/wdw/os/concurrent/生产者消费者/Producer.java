package wdw.os.concurrent.生产者消费者;

import wdw.os.concurrent.生产者消费者.useAwait.BufferUsingAwait;

public class Producer implements Runnable {
    Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(500);
                buffer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
