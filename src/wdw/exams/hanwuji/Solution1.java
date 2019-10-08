package wdw.exams.hanwuji;
/*
4
2016 2 20 0
2017 3 20 1
2016 3 21 2
2017 3 20 3
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        int[][] tab = new int[N][4];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 4; j ++){
                tab[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        int[] val = new int[N];
        int[] index = new int[N];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < N; i ++){
            val[i] = tab[i][0] + (tab[i][1] * 100 + tab[i][2]) * 1000;
            index[i] = tab[i][3];
            map.put(index[i],val[i]);
        }
        Arrays.sort(index);
        for (int i=0; i<N-1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (map.get(index[j]) > map.get(index[j + 1])) {
                    int temp = index[j];
                    index[j] = index[j + 1];
                    index[j + 1] = temp;
                }
            }
        }
        for(int i = 0; i < N; i++){
            int j = index[i];
            System.out.println(tab[j][1] + " " + tab[j][2] + " " + tab[j][0] + " " + tab[j][3]);
        }
    }
}
