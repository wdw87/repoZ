package wdw.exams.zuoyebang;

import java.util.Scanner;
public class Solution {
    protected static int coinChange1(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                if(coins[i] == j){
                    dp[j] = 1;
                }else{
                    if(dp[j - coins[i]] != 0){
                        if(dp[j] != 0){
                            dp[j] = Math.min(dp[j - coins[i]] + 1,dp[j]);
                        }else{
                            dp[j] = dp[j - coins[i]] + 1;
                        }
                    }
                }
            }
        }
        return dp[amount] == 0? -1 : dp[amount];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        String[] strArr = str.split(" ");
        int[] coins = new int[strArr.length];
        for(int i = 0; i < coins.length; i++){
            coins[i] = Integer.parseInt(strArr[i]);
        }
        System.out.println(coinChange1(coins,amount));
    }
}
