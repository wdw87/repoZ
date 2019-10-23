package wdw.math;

/**
 * 求最大公约数的辗转相除法
 */
public class MaximumCommonDivisor {
    //辗转相除就是这个了
    public static int gcd(int a,int b){
        if(b == 0) return a;
        return gcd(b,a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(44,22));
    }
}
