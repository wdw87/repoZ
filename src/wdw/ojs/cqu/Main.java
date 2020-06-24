package wdw.ojs.cqu;

import java.util.Scanner;

public class Main {
    private int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public void dfs(char[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1'){
            return ;
        }
        grid[x][y] = '2';
        for(int[] d : dir){
            dfs(grid, x + d[0], y + d[1]);
        }
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int cnt = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    cnt ++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int i = 0; i < N; i++){

        }
    }
}
