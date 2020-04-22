package wdw.exams.niukemoni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            if((i & 1) == 0) {
                list.add(arr[i]);
            }else {
                stack.push(arr[i]);
            }
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        int max = Math.abs(list.get(0) - list.get(n - 1));
        for(int i = 1; i < n; i++){
            max = Math.max(max, Math.abs(list.get(i) - list.get(i - 1)));
        }

        System.out.println(max);
    }
}
