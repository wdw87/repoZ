package wdw.exams.test;

/**
 20
 10
 3 8 5 9 2 3 5 7 4 3
 1 2 3 4 5 6 7 8 9 10
 */

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        scanner.nextLine();
        int N = scanner.nextInt();
        scanner.nextLine();
        int m[] = new int[N];
        int v[] = new int[N];
        for(int i = 0; i < N; i ++){
            m[i] = scanner.nextInt();
        }
        scanner.nextLine();
        for(int i = 0; i < N; i ++){
            v[i] = scanner.nextInt();
        }
        scanner.nextLine();
        int[] dp = new int[M + 1];

        for(int i = 0; i < N; i++){
            for(int j = M; j >= m[i]; j--){
                dp[j] = Math.max(dp[j], v[i] + dp[j - m[i]]);
            }
        }
        System.out.println(dp[M]);
    }
}
