package wdw.math;

/**
 * 快速求组合数，lacus算法
 * https://www.cnblogs.com/fzl194/p/9095177.html
 */
public class CmnModk {
    static long pow(long a, long b, long m) {
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

    static long inv(long x, long p)//x关于p的逆元，p为素数
    {
        return pow(x, p - 2, p);
    }

    static long C(long n, long m, long p)//组合数C(n, m) % p
    {
        if (m > n) return 0;
        long up = 1, down = 1;//分子分母;
        for (long i = n - m + 1; i <= n; i++) up = up * i % p;
        for (long i = 1; i <= m; i++) down = down * i % p;
        return up * inv(down, p) % p;
    }

    static long Lucas(long n, long m, long p) {
        if (m == 0) return 1;
        return C(n % p, m % p, p) * Lucas(n / p, m / p, p) % p;
    }

    public static void main(String[] args) {
        System.out.println(Lucas(5, 3, 7));
    }
}
