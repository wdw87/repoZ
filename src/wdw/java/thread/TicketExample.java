package wdw.java.thread;

class Station implements Runnable {
    private int tickets = 10;

    public synchronized void buyTicket() {
        try {
            Thread.sleep(10);
            while(tickets <= 0)
                wait();
            if (tickets > 0) {
                tickets--;
                System.out.println(Thread.currentThread().getName() + "->" + tickets);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void addTickets(int num){
        tickets += num;
        notifyAll();
    }
    @Override
    public void run() {
        while (true) {
            buyTicket();
        }
    }
}

public class TicketExample {
    public static void main(String[] args) {
        Station station = new Station();
        new Thread(station).start();
        System.out.println("Main run");
    }
}
