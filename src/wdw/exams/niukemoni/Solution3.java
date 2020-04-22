package wdw.exams.niukemoni;

import java.util.Scanner;

/**
 * 从0～n-1 ，n个数字
 * 选 k 个， 使得k个数字之和 被n整除
 * 求所有可以选取的方案数
 */
public class Solution3 {

    private static int M = 1000000007;

    public static void solution(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        // dp[i][j][t] : 前i个数字中选出j个，除以n余数为t的方案数
        int[][][] dp = new int[n + 1][k + 1][n];
        for(int i = 0; i <= n; i++){
            dp[i][0][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                for(int t = 0; t < n; t++){
                    /**
                     * 不选第i个数 dp[i - 1][j][t]
                     * 选第i个数：dp[i - 1][j - 1][(n + t - i) % n]
                     */
                    dp[i][j][t] = (dp[i - 1][j][t] + dp[i - 1][j - 1][(n + t - i) % n]) % M;
                }
            }
        }

        System.out.println(dp[n][k][0]);


    }

    /**
     * 状态压缩
     * @param args
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        // dp[i][j][t] : 前i个数字中选出j个，除以n余数为t的方案数
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = k; j > 0; j--){
                for(int t = 0; t < n; t++){
                    /**
                     * 不选第i个数 dp[i - 1][j][t]
                     * 选第i个数：dp[i - 1][j - 1][(n + t - i) % n]
                     */
                    dp[j][t] = (dp[j][t] + dp[j - 1][(n + t - i) % n]) % M;
                }
            }
        }

        System.out.println(dp[k][0]);
    }
}
