package wdw.exams.kuaishou;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][][] dp = new int[2 * n + 1][n + 1][n + 1];
        dp[0][0][0] = 1;
        for(int i = 1; i <= 2 * n; i++){
            for(int j = 0; j <= n; j++){
                for(int k = j; k <= n; k++){
                    if(j > 0){
                        dp[i][j][k] += dp[i - 1][j - 1][k];
                    }
                    if(k > 0){
                        dp[i][j][k] += dp[i - 1][j][k - 1];
                    }
                }
            }
        }
        int sum = 0;
        for(int j = 0; j <= n; j++){
            for(int k = j; k <= n; k++){
                sum += dp[2 * n][j][k];
            }
        }
        System.out.println(sum);
    }
}
