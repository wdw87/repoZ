package wdw.designPattern.single;

public class Singleton2 {
    private static volatile Singleton2 INSTANCE = null;

    private Singleton2(){}

    public static Singleton2 getInstance(){
        if(INSTANCE == null){
            synchronized (Singleton2.class){
                if(INSTANCE == null){
                    INSTANCE = new Singleton2();
                }
            }
        }
        return INSTANCE;
    }
}
