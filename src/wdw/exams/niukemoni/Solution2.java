package wdw.exams.niukemoni;

import java.util.Random;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Random random = new Random(7);
        int sum = 0;
        int T = 10000;
        for(int i = 0; i < T; i++){
            int tmp = 0;
            int red = 1;
            int left = 0;
            int right = 0;
            for(int j = 0; j < n; j++){
                if(random.nextBoolean()){
                    tmp ++;
                }else{
                    tmp --;
                }
                left = Math.min(left, tmp);
                right = Math.max(right, tmp);
            }
            sum += right - left + 1;
        }
        int num1 = sum / T;
        int num2 = sum * 10 / T % 10 + 1;
        System.out.println(num1 + "." + num2);

    }
}
