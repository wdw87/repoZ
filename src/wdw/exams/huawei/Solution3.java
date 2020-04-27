package wdw.exams.huawei;

import javax.security.auth.SubjectDomainCombiner;
import java.util.Scanner;

public class Solution3 {
    public static boolean check(int[] arr, int k, int mid){
        int i = 0;
        int tmp = 0;
        while(i < arr.length){
            tmp += arr[i];
            if(tmp >= mid){
                tmp = 0;
                k --;
            }
            i ++;
        }
        return k <= 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[m];
        for(int i = 0; i < m; i++){
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = Integer.MAX_VALUE;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(check(arr, k, mid)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        left --;

        int tmp = 0;
        for(int i = 0; i < arr.length; i++){
            tmp += arr[i];
            if(i != arr.length - 1){
                System.out.print(arr[i] + " ");
            }else{
                System.out.println(arr[i]);
            }
            if(tmp >= left && i != arr.length - 1){
                tmp = 0;
                System.out.print("/ ");
            }
        }
    }
}
