package wdw.exams.xiaohongshu;
/*
5
.#...
..#S.
.E###
.....
.....
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int mod(int x, int y) {
        while (x < 0) {
            x += y;
        }
        return x % y;
    }
    static void call(char[][] grid, int nx, int ny, int steps, List<Integer> all){
        if (grid[nx][ny] != '#') {
            if (grid[nx][ny] != 'E'){
                grid[nx][ny] = '#';
                nextStep(grid, nx, ny, steps, all);
                grid[nx][ny] = '.';
            }else{
                nextStep(grid, nx, ny, steps, all);
            }
        }
    }
    public static void nextStep(char[][] grid, int nx, int ny, int steps, List<Integer> all) {
        if (grid[nx][ny] == 'E') {
            all.add(steps);
        } else {
            int tmpx = mod((nx - 1), grid.length);
            call(grid, tmpx, ny, steps + 1, all);
            tmpx = mod((nx + 1), grid.length);
            call(grid, tmpx, ny, steps + 1, all);
            int tmpy = mod((ny - 1), grid[0].length);
            call(grid, nx, tmpy, steps + 1, all);
            tmpy = mod((ny + 1), grid[0].length);
            call(grid, nx, tmpy, steps + 1, all);
            return;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        char[][] grid = new char[N][N];
        int sx = 0, sy = 0;
        for (int i = 0; i < N; i++) {
            String str = scanner.nextLine();
            int idx = str.indexOf("S");
            if (idx != -1) {
                sx = i;
                sy = idx;
            }
            grid[i] = str.toCharArray();
        }
        List<Integer> list = new ArrayList<>();

        nextStep(grid, sx, sy, 0, list);

        if (list.size() == 0) {
            System.out.println(0);
        } else {
            list.sort(Integer::compareTo);
            System.out.println(list.get(0));
        }
    }
}
