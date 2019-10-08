package wdw.ojs.hdu2046;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            if(m  == 1){
                System.out.println(1);
                continue;
            }
            if(m == 2){
                System.out.println(2);
                continue;
            }
            long[] dp = new long[3];
            dp[0] = 1;
            dp[1] = 2;
            for(int i = 2; i < m; i++){
                dp[2] = dp[0] + dp[1];
                dp[0] = dp[1];
                dp[1] = dp[2];
            }
            System.out.println(dp[2]);
        }
    }

}
