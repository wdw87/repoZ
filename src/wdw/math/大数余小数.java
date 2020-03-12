package wdw.math;

/**
 * 　　对于一些大数取余，可以利用模拟手算取余的方法进行计算。
 *
 * 　　e.g.有一个大数989565215785528545587（大数）对10003（小数）取余，需要将该大数从最左端开始对10003取余；
 *
 * 　　　　start:
 *
 * 　　　　　　9%10003==9;
 *
 * 　　　　　　(9*10+8)%10003==98;
 *
 * 　　　　　　(98*10+9)%10003==989;
 *
 * 　　　　　　(989*10+5)%10003==9895;
 *
 * 　　　　　　(9895*10+6)%10003==8929;
 *
 * 　　　　　　(8929*10+5)%10003==9271;
 *
 * 　　　　　　......
 */
public class 大数余小数 {
    public static long calculate(String n1, long n2){

        long res = 0;

        for(int i = 0; i < n1.length(); i++){
            res = (res * 10 + (n1.charAt(i) - '0')) % n2;
        }

        return res;
    }


    public static void main(String[] args) {
        String n1 = "532535523452452577777777777777484848484848499999999999999595995959595959593845892475982789670295";
        long n2 = 10003;
        System.out.println(calculate(n1, n2));
    }
}
