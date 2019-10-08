package wdw.ojs.hangdianOJ.CoinChange;
/**
 * err!!!!!!!!
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] coins = {1,5,10,25,50};
        while(sc.hasNext()){
            int amount = sc.nextInt();
            int[] dp = new int[amount + 1];
            //init
            dp[0] = 1;
            for(int coin : coins){
                if(coin <= amount){
                    dp[coin] = 1;
                }
            }
            //dp
            for(int i = 1; i <= amount; i ++){
                for(int coin : coins){
                    if(i - coin >= 0 )
                        dp[i] += dp[i - coin];
                }
            }
            System.out.println(dp[amount]);
        }
    }
}
