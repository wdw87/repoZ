package wdw.classic.structures.bigraph;

import java.util.Arrays;

public class MaximumMatching {
    public static int m = 0, n = 0; //二分图左边顶点数和右边顶点数

    public static boolean find(int[][] graph, boolean[] used, int[] linked, int start) {
        for (int next = 0; next < n; next++) {
            if (graph[start][next] == 1 && used[next] == false) {
                used[next] = true;
                //下一个点未连接，连接之
                //下一个点已连接，寻找其他的连接方式，为该点腾位置
                if (linked[next] == -1 || find(graph, used, linked, linked[next])) {
                    linked[next] = start;
                    return true;
                }
            }
        }
        return false;
    }

    public static int hungary(int[][] graph) { //匈牙利算法，返回最大匹配数
        int count = 0;
        int[] linked = new int[n]; //注意
        Arrays.fill(linked, -1);
        //从每一个 左边点 出发，寻找增广路
        for (int i = 0; i < m; i++) {
            boolean[] used = new boolean[n]; //注意
            if (find(graph, used, linked, i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        m = 5;
        n = 4;
        int[][] graph = new int[m][n];
        graph[0][0] = graph[0][1] = 1;
        graph[1][0] = graph[1][2] = 1;
        graph[2][0] = graph[2][1] = graph[2][2] = graph[2][3] = 1;
        graph[3][1] = graph[3][3] = 1;
        graph[4][2] = graph[4][3] = 1;
        System.out.println(hungary(graph));
    }


}
