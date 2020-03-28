package wdw.exams.niukemoni;

import java.util.Scanner;

public class Solution3 {

    private static int M = 1000000007;

    public static int dfs(int start, int end, int k,int sum, boolean[] used){
        if(start >= end || k == 0){
            if(k == 0 && sum == 0){
                return 1;
            }else if(k != 0){
                return 0;
            }
            return 0;
        }
        int res = 0;

        for(int i = start; i < end; i++){
            if(used[i]) continue;
            used[i] = true;
            res = (res + dfs(i + 1, end, k - 1,sum - i, used)) % M;
            used[i] = false;

        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int res = 0;
        for(int i = n; i < n * n / 2; i += n){
            res += dfs(0, n, k, i, new boolean[n]);
        }
        System.out.println(res);


    }
}
