package wdw.exams.baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int ans = 0;
        List<Integer> cash = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int val = scanner.nextInt();
            int num = scanner.nextInt();
            scanner.nextLine();
            if(val >= m)
                ans += num;
            else{
                for(int j = 0; j < num; j++){
                    cash.add(val);
                }
            }
        }
        cash.sort(Integer::compareTo);
        int r = cash.size() - 1;
        int l = r - 1;
        int tmp = cash.get(r);
        int[] flag = new int[cash.size()];
        flag[r] = 1;
        int err = m - tmp;
        while(r > 0) {
            while(flag[r] == 1){
                r--;
            }
            l = r - 1;
            while(l > 0 && cash.get(l) > err && flag[l] != 1)
                l--;
            if(flag[l] != 1){
                err -= cash.get(l);
                flag[l] = 1;
            }
            if(err <= 0){
                ans += 1;
                break;
            }
        }
        System.out.println(ans);
    }
}
