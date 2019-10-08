package wdw.exams.xiaomi;
import java.util.Scanner;
import java.util.Stack;
/*
某种格式存储二叉树
1(2(3,4(,5)),6(7,))
输出中序遍历
 */
class Node{
    int val;
    Node(int x){
        val = x;
    }
    Node parent;
    Node left;
    Node right;
}
public class Solution {
    public static void recursionMiddleorderTraversal(Node root) {
        if (root != null) {
            recursionMiddleorderTraversal(root.left);
            System.out.print(root.val);
            recursionMiddleorderTraversal(root.right);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        String str = scanner.nextLine();
        Node root = new Node(str.charAt(0) - '0');
        Node p = root;
        Node last = root;
        int i = 1;
        while(i < str.length()){
            if(str.charAt(i) == '('){
                i++;
                if(str.charAt(i) == ','){
                    p.left = null;
                }else {
                    p.left = new Node(str.charAt(i) - '0');
                    last = p;
                    p = p.left;
                    p.parent = last;
                    i++;
                }
            }else if(str.charAt(i) == ','){
                if(str.charAt(i - 1) != '('){
                    p = p.parent;
                }
                i++;
                if(str.charAt(i) == ')')
                    p.right = null;
                else{
                    p.right = new Node(str.charAt(i) - '0');
                    last = p;
                    p = p.right;
                    p.parent = last;
                    i++;
                }
            }else if(str.charAt(i) == ')'){
                if(str.charAt(i) != ',')
                    p = p.parent;
                i++;
            }
        }
        recursionMiddleorderTraversal(root);
    }
}
