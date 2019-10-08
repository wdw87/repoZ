package wdw.exams.qq;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while(T -- > 0){
            int n = sc.nextInt();
            sc.nextLine();
            int[] x = new int[n + 1];
            int sum = 0;
            for(int i = 1; i <= n; i ++){
                x[i] = sc.nextInt();
                sum += x[i];
            }
            sc.nextLine();
            //init
            int halfSum = sum / 2;
            int[][] dp = new int[halfSum + 1][n / 2 + 1];
            for(int i = 1; i <= n; i++){
                for(int j = halfSum; j >= 1; j--){
                    for(int k = n / 2; k >=1; k--){
                        if(j - x[i] >= 0)
                            dp[j][k] = Math.max(dp[j][k],dp[j - x[i]][k - 1] + x[i]);
                    }
                }
            }
            System.out.println(dp[halfSum][n / 2] + " " + (sum - dp[halfSum][n / 2]));
        }
    }
}
