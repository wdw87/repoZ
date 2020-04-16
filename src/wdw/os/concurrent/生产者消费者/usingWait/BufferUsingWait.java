package wdw.os.concurrent.生产者消费者.usingWait;

import wdw.os.concurrent.生产者消费者.Buffer;

import java.util.LinkedList;

public class BufferUsingWait implements Buffer {
    private int maxSize;

    private final LinkedList<Object> list = new LinkedList<>();

    public BufferUsingWait(int maxSize){
        this.maxSize = maxSize;
    }

    public void produce(){
        synchronized (list){
            while(list.size() >= maxSize){
                System.out.println("Producer Thread -" + Thread.currentThread().getName() + ": buffer is full...");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.offer(new Object());
            System.out.println("Producer Thread -" + Thread.currentThread().getName() + ": produced object");
            list.notifyAll();
        }
    }

    public void consume(){
        synchronized (list){
            while(list.size() == 0){
                System.out.println("Consumer Thread -" + Thread.currentThread().getName() + ": buffer is empty...");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.poll();
            System.out.println("Consumer Thread -" + Thread.currentThread().getName() + ": consumed object");
            list.notifyAll();
        }
    }

}
