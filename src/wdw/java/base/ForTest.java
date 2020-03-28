package wdw.java.base;

public class ForTest {
    public static void main(String[] args) {
        /**
         * for循环的条件这样写很蠢！！！！！！
         * 循环到 1 就停了！！！！
         */
        for(int i = 0; i < 4 && i != 1; i++){
            System.out.print(i + ",");
        }
        System.out.println();
        /**
         * 正解....
         */
        for(int i = 0; i < 4; i++){
            if(i == 1) continue;
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
