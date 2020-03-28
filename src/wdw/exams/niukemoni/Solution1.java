package wdw.exams.niukemoni;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {

    public static boolean check(int[] arr, int mid){
        boolean[] used = new boolean[arr.length];
        used[0] = true;
        int large = arr[0];
        int small = arr[0];
        int cnt = 1;
        while(cnt < arr.length){
            int last = -1;
            for(int i = 1; i < arr.length; i++){
                if(used[i]) continue;
                if(arr[i] - small <= mid){
                    last = i;
                }else {
                    break;
                }
            }
            if(last == -1) return false;
            used[last] = true;
            small = arr[last];
            if(small > large){
                int tmp = large;
                large = small;
                small = tmp;
            }

            cnt ++;
        }
        return large - small <= mid;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int left = 0;
        int right = 100;
        while(left < right){
            int mid = (left + right) / 2;
            if(check(arr, mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}
