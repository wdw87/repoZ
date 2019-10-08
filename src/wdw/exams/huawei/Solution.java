package wdw.exams.huawei;

import java.util.Scanner;

public class Solution {
    public final static long MOD = 1000000007;
    public static long C(long n, long m)
    {
        long res = 1;
        for(long i = 1; i <= m; ++i)
            res = res*(n-m+i)/i;
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        long c1 = n + m - 1;
        long c2 = m;
        long res = C(c1,c2) % 1000000007;
        if(res < 0)
            res = -res;
        System.out.println(res);
    }
}
