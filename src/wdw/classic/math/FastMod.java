package wdw.classic.math;

/**
 * 快速乘法取模，大数相乘取模
 * a * b mod m
 * 就把一个数不断除以2，一个数不断乘以2，如果b%2 == 1的话就在加一个a，因为类似于5*3啊，5+5*2对吧。。。
 */
public class FastMod {
    private static long fastMod(long a, long b,long m){
        long ans = 0;
        while(b != 0){
            if((b & 1) == 1){//判断奇偶
                ans += a;
                ans %= m;
            }
            a *= 2;
            a %= m;
            b /= 2;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(fastMod(222222322223452222L,33333333333333333L,5555555555555555L));
    }
}
