package wdw.math;

/**
 * 卡特兰数---组合数学中常出现在各种问题中的数
 * 递推关系1:
 * C[n] = c(2n,n) - c(2n,n + 1)
 *      = 1/(n+1) * c(2n,n)
 * 递推关系2:
 * C[0] = 1;
 * C[n + 1] = 2*(2*n+1)/(n+2) * C[n]
 *
 * 应用：
 * 给定节点组成二叉搜索树
 * 给定N个节点，能构成多少种不同的二叉搜索树？
 * （能构成h（N）个）
 * （这个公式的下标是从h(0)=1开始的）
 * n对括号正确匹配数目
 * 给定n对括号，求括号正确配对的字符串数，
 * 等等https://zh.wikipedia.org/wiki/%E5%8D%A1%E5%A1%94%E5%85%B0%E6%95%B0
 *
 */
public class CatalanNumber {
    public static long getCatalan(int n){
        long C = 1;
        for(int i = 0; i < n; i++){
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return C;
    }
    public static void main(String[] args) {
        System.out.println(getCatalan(0));
        System.out.println(getCatalan(1));
        System.out.println(getCatalan(2));
        System.out.println(getCatalan(3));
        System.out.println(getCatalan(4));
        System.out.println(getCatalan(5));
    }
}
