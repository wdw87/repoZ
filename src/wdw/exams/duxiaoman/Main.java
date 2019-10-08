package wdw.exams.duxiaoman;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Node implements Comparable<Node>{
        int num;//点编号
        int val;//点权值
        Node(int n,int v){
            this.num = n;
            this.val = v;
        }
        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        scanner.nextLine();
        int[] a = new int[N + 1];
        for(int i = 1; i <= N; i ++){
            a[i] = scanner.nextInt();
        }
        int[] dis = new int[N + 1];
        //init 第一个点到各点的距离
        for(int i = 2; i <= N; i ++){
            if(a[i] - i > 0)
                dis[i] = A + B ;
        }
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0)); //将起点放入队列
        while(!pq.isEmpty()){




        }

    }
}
