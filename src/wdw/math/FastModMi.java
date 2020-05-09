package wdw.math;

/**
 * 快速幂取模
 * a ^ b  mod m
 */
public class FastModMi {
    public static long fastMod1(long a, long b, long m) {
        long ans = 1;
        a %= m;
        while (b != 0) {
            if ((b & 1) != 0)
                ans = (ans % m) * (a % m) % m;
            b /= 2;
            a = (a % m) * (a % m) % m;
        }
        ans %= m;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fastMod1(2, 4, 5));
        System.out.println(fastMod1(22, 433, 56));
    }
}
