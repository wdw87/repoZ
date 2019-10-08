package wdw.exams.disjoitSet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DisjointSet {
    private static void init(int parent[]){
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
    }
    private static int findRoot(int x, int parent[]){
        if(x == parent[x]){
            return x;
        }else{
            parent[x] = findRoot(parent[x],parent);
            return parent[x];
        }
    }
    private static int unionNodes(int x, int y, int[] parent,int[] rank){
        int xRoot = findRoot(x,parent);
        int yRoot = findRoot(y,parent);
        if(xRoot == yRoot){
            return 0;
        }else{
            if(rank[xRoot] > rank[yRoot]){
                parent[yRoot] = xRoot;
            }else if(rank[yRoot] > rank[xRoot]){
                parent[xRoot] = yRoot;
            }else{
                parent[xRoot] = yRoot;
                rank[yRoot]++;
            }
            //parent[xRoot] = yRoot;
            return 1;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        while (T-- != 0){
            Set<Integer> set = new HashSet<>();
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            scanner.nextLine();
            int[] parent = new int[N + 1];
            int[] rank = new int[N + 1];
            init(parent);
            while (M -- != 0){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                scanner.nextLine();
                unionNodes(x,y,parent,rank);
            }
            for(int i = 1; i < parent.length; i++){
                set.add(findRoot(i,parent));
            }
            System.out.println(set.size());
        }
    }
}
