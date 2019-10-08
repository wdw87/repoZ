package wdw.exams.hanwuji;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt();
        int R = scanner.nextInt();
        int B = scanner.nextInt();


        while(B > 0){
            if(L < R){
                L ++;
                B --;
            }else{
                R ++;
                B --;
            }
        }
        System.out.println(Math.min(L,R) * 2);
    }
}
