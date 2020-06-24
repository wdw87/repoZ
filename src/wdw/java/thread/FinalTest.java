package wdw.java.thread;

import java.util.ArrayList;
import java.util.List;

public class FinalTest {
    private static final List<Integer> list = new ArrayList<>();

    private static final FinalTest FINAL_TEST = null;


    public FinalTest getFinalTest(){
        //FINAL_TEST = new FinalTest(); //这句话会报错，final已经赋值为null了 不可变
        return FINAL_TEST;
    }

}
