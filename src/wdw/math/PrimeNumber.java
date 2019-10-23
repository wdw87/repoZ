package wdw.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 素数相关
 *
 */
public class PrimeNumber {
    /**
     * 素数检测
     * d是n的约数，那么n/d也是n的约数，由n = d * (n / d)可知，min(d,n/d) <= sqr(n) ,所以只需要检查 2 ~ sqr(n) 的数就足够了 ,要注意1是特例
     * @param
     * @return
     */
    public static boolean isPrime(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return n != 1;
    }

    /**
     * 素数检测 --- 约数枚举
     * 就是将n的所有的约数给保存下来，看一下这些约数的个数是不是2，如果是2的话这个数就是素数，否则就不是。
     * @param n
     * @return
     */
    public static List<Integer> divisor(int n){
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                res.add(i);
                if(i != n / i)
                    res.add(n / i);
            }
        }
        return  res;
    }

    /**
     * 整数分解法，将整数分解质因数
     * @param n
     * @return
     */
    public static Map<Integer,Integer> pirmeFactor(int n){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 2; i * i <= n; i++){
            while(n % i == 0){
                if(map.containsKey(i))
                    map.put(i,map.get(i) + 1);
                else
                    map.put(i,1);
                n /= i;
            }
        }
        if(n != 1) map.put(n,1);
        return map;
    }

    public static void main(String[] args) {
        Map<Integer,Integer> map = pirmeFactor(11);
        System.out.println(map.size());
    }
}
