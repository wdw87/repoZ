package wdw.java.thread;


import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Sender implements Runnable{
    private Random rand = new Random(47);
    private PipedWriter out = new PipedWriter();
    public PipedWriter getPipedWriter(){return out;}
    @Override
    public void run() {
        try {
            for(char c = 'A'; c <= 'Z'; c++){
                out.write(c);
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class Receiver implements Runnable{
    private PipedReader in;
    public Receiver(Sender sender) throws IOException{
        in = new PipedReader(sender.getPipedWriter());
    }
    @Override
    public void run() {
        try {
            while(true){
                System.out.println("Resd: " + (char)in.read() + ", ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class PipeTest {
    public static void main(String[] args) throws Exception{
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}
