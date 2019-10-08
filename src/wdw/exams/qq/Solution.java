package wdw.exams.qq;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        sc.nextLine();
        for(int i = 0; i< n; i++){
            a[i] = sc.nextInt();
        }
        sc.nextLine();
        for(int i = 0; i< n; i++){
            b[i] = sc.nextInt();
        }
        sc.nextLine();
        int res = 0;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++){
                res ^= (a[i] + b[j]);
            }
        }
        System.out.println(res);
    }
}
