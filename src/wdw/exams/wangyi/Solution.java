package wdw.exams.wangyi;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        long[] nums = new long[n];
        long[] maxs = new long[n];
        //记录上一次最小值
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLong();
            maxs[i] = nums[i];
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        System.out.print(min + " ");
        for (int k = 2; k <= n; k++) {
            min = Long.MAX_VALUE;
            for (int i = 0; i <= n - k; i++) {
                long max = Math.max(nums[i], maxs[i + 1]);
                maxs[i] = max;
                if (max < min) {
                    min = max;
                }
            }
            if (k == n) {
                System.out.print(min);
            } else {
                System.out.print(min + " ");
            }

        }

    }
}
