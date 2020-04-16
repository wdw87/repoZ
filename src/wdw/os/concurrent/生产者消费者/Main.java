package wdw.os.concurrent.生产者消费者;

import wdw.os.concurrent.生产者消费者.useAwait.BufferUsingAwait;

public class Main {

    public static void main(String[] args) {
        Buffer buffer = new BufferUsingAwait(10);
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        for(int i = 0; i < 5; i++){
            new Thread(producer).start();
        }

        for(int i = 0; i < 3; i++){
            new Thread(consumer).start();
        }
    }
}
