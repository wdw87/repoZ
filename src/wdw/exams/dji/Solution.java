package wdw.exams.dji;

public class Solution {
    public static void main(String[] args) {
        int n = 3;
        int[][] a = {{9,8,7}, {6,5,4}, {3,2,1}};

        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int row = 0;
            int col = 0;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (a[i][j] < min) {
                    min = a[i][j];
                    row = i;
                    col = j;
                }
            }
            for (int k = 0; k < n; k++) {
                if (min < a[k][col]) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("row=" + row + ",col=" + col);
            }
        }
    }
}
