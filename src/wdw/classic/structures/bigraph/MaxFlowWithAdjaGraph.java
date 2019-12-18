package wdw.classic.structures.bigraph;

import java.util.Arrays;

public class MaxFlowWithAdjaGraph {
    private static int MAX_N = 0;
    private static boolean[] used = null;
    private static int[][] G = null;

    public static void addEdge(int from, int to, int cap){
        G[from][to] = cap;
        G[to][from] = 0;
    }

    public static int dfs(int v, int t, int f){
        if(v == t){
            return f;
        }
        used[v] = true;
        for(int i = 0; i < G[v].length; i++){
            if(G[v][i] == -1){
                continue;
            }
            if(!used[i] && G[v][i] > 0) {
                int d = dfs(i, t, Math.min(G[v][i], f));
                if (d > 0) {
                    G[v][i] -= d;
                    G[i][v] += d;
                    return d;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MAX_N = 6;
        G = new int[MAX_N][MAX_N];
        for(int i = 0; i < MAX_N; i++){
            Arrays.fill(G[i],-1);
        }
        addEdge(0,1,10);
        addEdge(0,3,10);
        addEdge(1,2,4);
        addEdge(1,3,2);
        addEdge(1,4,8);
        addEdge(2,5,10);
        addEdge(3,4,9);
        addEdge(4,2,6);
        addEdge(4,5,10);
        int res = 0;
        while(true){
            used = new boolean[MAX_N];
            int f = dfs(0,5,Integer.MAX_VALUE);
            if(f == 0){
                break;
            }
            res += f;
        }
        System.out.println(res);
    }

}
