package wdw.java.thread;

class Counter {
    protected long count;
    public Counter(){};
    public Counter(long count){
        this.count = count;
    }
    public void add() {
        count++;
    }
}

public class SynchronizeTest {
    public static void main(String[] args) {
        Counter counter = new Counter(0);

        for(int i = 0; i < 100; i++){
            new Thread(()->{
                try{
                    Thread.sleep(100);
                    counter.add();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }).start();
        }
        try{
            Thread.sleep(100);
            System.out.println(counter.count);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
