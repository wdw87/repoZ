package wdw.exams.kuaishou;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N  = scanner.nextInt();
        scanner.nextLine();
        int[] nums = new int[N];
        for(int i = 0; i < N ; i++){
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int diff = nums[N - 1] - nums[0];
        if(diff == 0){
            System.out.println(N);
            return;
        }
        int[][] dp = new int[N][diff + 1];
        for(int i = 0; i < N; i++)
            for(int j = 0; j <= diff; j++)
                dp[i][j] = 1;
        int longest = 1;
        for(int i = 0; i < N; i ++){
            for(int j = i - 1; j >= 0; j--){
                int tmp = nums[i] - nums[j];
                dp[i][tmp] = dp[j][tmp] + 1;
                longest = Math.max(longest,dp[i][tmp] );
            }
        }
        System.out.println(longest);
    }
}
