package wdw.classic.backpack;

import java.util.Scanner;

public class Coins {
    public static int coinChange1(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount + 1];

        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                if(coins[i] == j){
                    dp[j] = 1;
                }else{
                    //选coin[i]的情况下，要想凑成j，则：
                    //dp[j - coin[i]] != 0,即能凑成j - coins[i]
                    //否侧凑不成j，即不能选coin[i]，保持dp[j]不变
                    if(dp[j - coins[i]] != 0){
                        if(dp[j] != 0){
                            dp[j] = Math.min(dp[j - coins[i]] + 1,dp[j]);
                        }else{
                            dp[j] = dp[j - coins[i]] + 1;
                        }
                    }
                    // else{
                    //     dp[j] = dp[j];
                    // }
                }
            }
        }
        return dp[amount] == 0? -1 : dp[amount];
    }
    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];

        for(int j = 0; j <= amount; j++){
            dp[0][j] = j % coins[0] == 0 ? j / coins[0] : 0;
        }
        for(int i = 1; i < coins.length; i++){
            for(int j = 0; j <= amount; j++){
                if(coins[i] == j){
                    dp[i][j] = 1;
                }else{
                    if(j - coins[i] >= 0 && dp[i][j - coins[i]] != 0){
                        if(dp[i - 1][j] != 0){
                            dp[i][j] = Math.min(dp[i][j - coins[i]] + 1,dp[i - 1][j]);
                        }else{
                            dp[i][j] = dp[i][j - coins[i]] + 1;
                        }
                    }else if(dp[i - 1][j] != 0){
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        for(int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[coins.length - 1][amount] == 0? -1 : dp[coins.length - 1][amount];
    }

    public static void main(String[] args) {
//        int[] coins = {1,2};
//        int amount = 2;
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
