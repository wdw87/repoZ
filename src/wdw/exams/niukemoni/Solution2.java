package wdw.exams.niukemoni;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[][][] dp = new double[2][505][505]; // i, j, k 走i步，有j个红色的格子，在第k个格子上的概率

        dp[0][1][1] = 1;
        int curr = 0;
        int next = 1;
        for(int i = 1; i <= n; i++){ //走n步
            next = i % 2;

            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    dp[next][j][k] = 0;
                }
            }
            for(int j = 1; j <= n + 1; j++){ //走n步，最多有n + 1个红格子
                for(int k = 1; k <= j; k++){ // 1 ～ j
                    //left
                    if(k == 1){
                        dp[next][j + 1][1] += dp[curr][j][k] / 2;
                    }else{
                        dp[next][j][k - 1] += dp[curr][j][k] / 2;
                    }
                    //right
                    if(k == j){
                        dp[next][j + 1][k + 1] += dp[curr][j][k] / 2;
                    }else{
                        dp[next][j][k + 1] += dp[curr][j][k] / 2;
                    }

                }
            }
            curr = next;

        }
        double res = 0;
        for(int j = 1; j <= n + 1; j++){
            for(int k = 1; k <= j; k++) {
                res += dp[curr][j][k] * (double)j;
            }
        }
        DecimalFormat f = new DecimalFormat("0.0");
        System.out.println(f.format(res));
    }
}
