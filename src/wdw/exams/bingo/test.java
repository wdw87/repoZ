package wdw.exams.bingo;

import java.util.Scanner;

public class test {
    static int MaxSubSequence(int A[], int N)
    {
        int ThisSum,MaxSum,j;
        ThisSum = MaxSum =0;
        for(j = 0;j < N;j++)
        {
            ThisSum += A[j];

            if(ThisSum > MaxSum)
                MaxSum = ThisSum;
            else if(ThisSum < 0)
                ThisSum = 0;
        }
        return MaxSum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String s = str.replaceAll(" ","");
        String s1 = s.substring(1,s.length() - 1);
        String[] arrStr = s1.split(",");
        int N = arrStr.length;
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(arrStr[i]);
        }
        System.out.println(MaxSubSequence(nums,N));
    }
}
