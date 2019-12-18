package wdw.classic.structures.bigraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Ford-Fulkerson 算法求 最大流和最小割，最大流就是最小割
 * 关键边：非满前向边
 *         非空反向边
 *
 */
public class MaxFLowWithAdjaList {
    private static int MAX_N = 0;
    static class Edge{
        int to;
        int cap;
        int rev;
        Edge(int to, int cap, int rev){
            this.to = to; //边的后向结点
            this.cap = cap; //边的容量
            this.rev = rev; //反向边的索引
        }
    }
    private static boolean[] used = null;
    private static List<List<Edge>> G = null;
    public static void addEdge(int from, int to, int cap){
        G.get(from).add(new Edge(to,cap,G.get(to).size()));
        G.get(to).add(new Edge(from,0,G.get(from).size() - 1));
    }
    public static int dfs(int v, int t, int f){
        if(v== t){
            return f;
        }
        used[v] = true;
        for(int i = 0; i < G.get(v).size(); i++){
            Edge e = G.get(v).get(i);
            if(!used[e.to] && e.cap > 0){
                int d = dfs(e.to, t, Math.min(e.cap,f));
                if(d > 0){
                    e.cap -= d; //前向边增加流量（容量减小），
                    G.get(e.to).get(e.rev).cap += d;//对应的反向边减小流量（容量增加）
                    return d;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        MAX_N = 6;
        G = new ArrayList<>();
        for(int i = 0; i < MAX_N; i++){
            G.add(new ArrayList<Edge>());
        }
        int flow = 0;
//        addEdge(0,1,10);
//        addEdge(0,2,2);
//        addEdge(1,2,6);
//        addEdge(1,3,6);
//        addEdge(2,4,5);
//        addEdge(3,2,3);
//        addEdge(3,4,8);
        addEdge(0,1,10);
        addEdge(0,3,10);
        addEdge(1,2,4);
        addEdge(1,3,2);
        addEdge(1,4,8);
        addEdge(2,5,10);
        addEdge(3,4,9);
        addEdge(4,2,6);
        addEdge(4,5,10);
        while(true){
            used = new boolean[MAX_N];
            int f = dfs(0,5,Integer.MAX_VALUE);
            if(f == 0){
                break; // 得出了结果
            }
            flow += f;
        }
        System.out.println(flow);
    }
}
