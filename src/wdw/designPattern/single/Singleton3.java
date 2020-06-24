package wdw.designPattern.single;

public class Singleton3 {
    private static class SingletonHolder{
        public static Singleton3 singleton3 = new Singleton3();
    }

    public static Singleton3 getInstance(){
        return SingletonHolder.singleton3;
    }
}
