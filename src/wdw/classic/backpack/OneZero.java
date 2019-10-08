package wdw.classic.backpack;

public class OneZero {

    public static void main(String[] args) {

        int[] w = {0,2,1,3,2};
        int[] v = {0,3,2,4,2};
        int W = 5;
        int N = 4;

        int[][] dp = new int[N + 1][W + 1];

        int[] dp1 = new int[W + 1];

        for(int i = 1; i <= N; i++){
            for(int j = W; j >= w[i]; j--){
                dp1[j] = Math.max(dp1[j], v[i] + dp1[j - w[i]]);
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= W; j ++){
                if(j - w[i] >= 0){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
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
        System.out.println(dp1[W]);

    }
}
