package wdw.java.thread;

class Tickets {
    private int num;

    public Tickets(int num) {
        this.num = num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}

class Consumer implements Runnable {
    private Tickets tickets;

    public Consumer(Tickets tickets) {
        this.tickets = tickets;
    }

    @Override
    public void run() {
        synchronized (tickets) {
            try {
                while(true){
                    while (tickets.getNum() <= 0) {
                        tickets.wait();
                    }
                    tickets.setNum(tickets.getNum() - 1);
                    System.out.println("Buy a ticket ->" + tickets.getNum());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Productor implements Runnable {
    private Tickets tickets;

    public Productor(Tickets tickets) {
        this.tickets = tickets;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (tickets) {
            tickets.setNum(tickets.getNum() + 5);
            System.out.println("Add 5 tickets");
            tickets.notifyAll();
        }
    }
}

public class WaitNotifyTest {
    public static void main(String[] args) {
        Tickets tickets = new Tickets(3);
        Consumer consumer = new Consumer(tickets);
        Productor productor = new Productor(tickets);

        new Thread(consumer).start();
        new Thread(productor).start();

    }
}
