package wdw.exams.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class bTree{
    bTree(int val){
        this.val = val;
    }
    int val;
    bTree left;
    bTree right;
}
public class Main {
    public static void midOrder(bTree root){
        if(root == null)
            return;
        midOrder(root.left);
        System.out.println(root.val);
        midOrder(root.right);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<bTree> queue = new LinkedList<>();
        int depth = scanner.nextInt();
        scanner.nextLine();
        bTree root = new bTree(scanner.nextInt());
        scanner.nextLine();
        queue.add(root);
        for(int i = 2; i <= depth; i++){
            for(int j = 0; j < (int)Math.pow(2,i-1); j+=2){
                bTree left = new bTree(scanner.nextInt());
                scanner.nextLine();
                bTree right = new bTree(scanner.nextInt());
                scanner.nextLine();
                bTree parent = queue.poll();
                parent.left = left;
                parent.right = right;
                queue.add(left);
                queue.add(right);
            }
        }
        midOrder(root);
    }
}
