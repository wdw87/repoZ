package wdw.classic.backpack;

public class Unbounded {
    public static void main(String[] args) {
        int[] w = {0,2,1,3,2};
        int[] v = {0,3,2,4,5};
        int W = 5;
        int N = 4;

        int[][] dp = new int[N + 1][W + 1];

        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= W; j++){
                if(j - w[i] >= 0){
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - w[i]] + v[i]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= W; j++){
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        System.out.println(dp[N][W]);
    }
}
