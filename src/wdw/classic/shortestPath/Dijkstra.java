package wdw.classic.shortestPath;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Dijkstra {
    static class Node implements Comparable<Node>{
        int index;
        int dis;
        public Node(int i, int d){
            this.index = i;
            this.dis = d;
        }
        @Override
        public int compareTo(Node o) {
            return this.dis - o.dis;
        }
    }
    public static void dijkstra(int s,int[][] G,Node[] dis){
        Queue<Node> q = new PriorityQueue<>();
        q.offer(dis[s]);
        while (!q.isEmpty()){
            Node tmp = q.poll();
            for(int i = 0; i < G.length; i++){
                if(dis[i].dis > tmp.dis + G[tmp.index][i]){
                    dis[i].dis = tmp.dis + G[tmp.index][i];
                    q.offer(dis[i]);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N,M;
        Node[] dis = null;
        int[][] G = null;
        while(sc.hasNext()){
            N = sc.nextInt();
            M = sc.nextInt();
            sc.nextLine();
            G = new int[N][N];
            dis = new Node[N];
            //init
            for(int i = 0; i < N; i ++){
                dis[i] = new Node(i,(int)1e9);
                for(int j = 0; j < N; j ++){
                    G[i][j] = (int)1e9;
                }
            }
            for(int i = 0; i < M; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                int z = sc.nextInt();
                if(z < G[x][y])
                    G[x][y] = G[y][x] = z;
                sc.nextLine();
            }
            int s = sc.nextInt();
            int t = sc.nextInt();
            sc.nextLine();
            dis[s].dis = 0;
            dijkstra(s,G,dis);
            if(dis[t].dis != 1e9){
                System.out.println(dis[t].dis);
            }else{
                System.out.println(-1);
            }
        }
    }
}
