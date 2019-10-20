package wdw.classic.binarySearch;

/**
 * 二分解决  最大化最小值问题
 *
 *
 * 你有一大块巧克力，它由一些甜度不完全相同的小块组成。我们用数组 sweetness 来表示每一小块的甜度。
 *
 * 你打算和 K 名朋友一起分享这块巧克力，所以你需要将切割 K 次才能得到 K+1 块，每一块都由一些 连续 的小块组成。
 *
 * 为了表现出你的慷慨，你将会吃掉 总甜度最小 的一块，并将其余几块分给你的朋友们。
 *
 * 请找出一个最佳的切割策略，使得你所分得的巧克力 总甜度最大，并返回这个 最大总甜度。
 *
 * 示例 1：
 *
 * 输入：sweetness = [1,2,3,4,5,6,7,8,9], K = 5
 * 输出：6
 * 解释：你可以把巧克力分成 [1,2,3], [4,5], [6], [7], [8], [9]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-chocolate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class maxmin {
    //check()根据题目不同而不同
    private static boolean check(int[] s,int k,int m){
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < s.length; i++){
            sum += s[i];
            if(sum >= m){
                cnt ++;
                sum = 0;
            }
        }
        return cnt > k;
    }
    public static int maximizeSweetness(int[] sweetness, int K) {
        int l = 0;
        int r = (int)1e9;
        int res = 0;
        // for(int i = 0; i < sweetness.length; i++){
        //     r += sweetness[i];
        // }
        while(l <= r){
            int m = l + (r - l) / 2;
            if(check(sweetness,K,m)){
                res = m;
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] sweetness = {1,2,3,4,5,6,7,8,9};
        int K = 5;
        System.out.println(maximizeSweetness(sweetness,K));
    }
}
