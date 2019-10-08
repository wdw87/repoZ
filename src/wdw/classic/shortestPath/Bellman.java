package wdw.classic.shortestPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bellman {
    static class Edge{
        int from;
        int to;
        int w;
        public Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N,M;
        List<Edge> list = new ArrayList<>();
        int[] dis = null;
        while(scanner.hasNext()){
            N = scanner.nextInt();
            M = scanner.nextInt();
            list.clear();
            dis = new int[N];
            scanner.nextLine();
            for(int i = 0; i < M; i++){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int z = scanner.nextInt();
                scanner.nextLine();
                list.add(new Edge(x,y,z));
                list.add(new Edge(y,x,z));
            }
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            for(int i = 0; i < N; i ++){
                dis[i] = i == s ? 0 : Integer.MAX_VALUE;
            }for(int i = 0; i < N; i++){
                if(i == s)
                    continue;
                for(int j = 0; j < list.size(); j++){
                    int fr = list.get(j).from;
                    int to = list.get(j).to;
                    int w = list.get(j).w;
                    if(dis[to] > dis[fr] + w)
                        dis[to] = dis[fr] + w;
                }
            }
            if(dis[t] == Integer.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(dis[t]);
        }

    }
}
