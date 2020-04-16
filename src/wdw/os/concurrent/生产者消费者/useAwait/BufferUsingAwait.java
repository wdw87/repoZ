package wdw.os.concurrent.生产者消费者.useAwait;

import wdw.os.concurrent.生产者消费者.Buffer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BufferUsingAwait implements Buffer {
    private int maxSize;

    private final LinkedList<Object> list = new LinkedList<>();

    private ReentrantLock lock = new ReentrantLock();

    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    public BufferUsingAwait(int maxSize){
        this.maxSize = maxSize;
    }

    public void produce(){
        lock.lock();
        try {
            while(list.size() >= maxSize){
                System.out.println("Producer Thread -" + Thread.currentThread().getName() + ": buffer is full...");
                try {
                    full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.offer(new Object());
            System.out.println("Producer Thread -" + Thread.currentThread().getName() + ": produced object, now size: " + list.size());
            empty.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void consume(){
        lock.lock();
        try {
            while (list.size() == 0) {
                System.out.println("Consumer Thread -" + Thread.currentThread().getName() + ": buffer is empty...");
                try {
                    empty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.poll();
            System.out.println("Consumer Thread -" + Thread.currentThread().getName() + ": consumed object, now size: " + list.size());
            full.signalAll();
        }finally {
            lock.unlock();
        }
    }

}
