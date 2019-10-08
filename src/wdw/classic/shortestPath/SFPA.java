package wdw.classic.shortestPath;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SFPA {
    public static void sfpa(int s,int[][] G,int[] dis,boolean[] inq){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        inq[s] = true;
        while(!q.isEmpty()){
            int tmp = q.poll();
            inq[tmp] = false;
            for(int i = 0; i < G.length; i ++){
                if(dis[i] > dis[tmp] + G[tmp][i]){
                    dis[i] = dis[tmp] + G[tmp][i];
                    if(!inq[i]) {
                        q.offer(i);
                        inq[i] = true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N,M;
        int[] dis = null;
        boolean[] inq = null;
        int[][] G = null;
        while(sc.hasNext()){
            N = sc.nextInt();
            M = sc.nextInt();
            sc.nextLine();
            G = new int[N][N];
            dis = new int[N];
            inq = new boolean[N];
            //init
            for(int i = 0; i < N; i ++){
                dis[i] = (int)1e9;
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
            dis[s] = 0;
            sfpa(s,G,dis,inq);
            if(dis[t] != 1e9){
                System.out.println(dis[t]);
            }else{
                System.out.println(-1);
            }
        }
    }
}
