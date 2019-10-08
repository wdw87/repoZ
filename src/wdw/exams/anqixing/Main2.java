package wdw.exams.anqixing;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        scanner.nextLine();
        String inputString = scanner.nextLine();
        String[] stringArray = inputString.split(" ");
        int nums[] = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            nums[i] = Integer.parseInt(stringArray[i]);
        }
        int avg = 0;
        for(int i = 0; i< nums.length; i++){
            avg += nums[i];
        }
        avg /= nums.length;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= avg){
                nums[i] += K;
            }else{
                nums[i] -=K;
            }
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        System.out.println(max - min);
    }
}
