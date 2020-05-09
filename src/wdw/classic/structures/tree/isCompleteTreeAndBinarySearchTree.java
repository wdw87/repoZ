package wdw.classic.structures.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 判断是完全二叉树  和  二叉搜索树
 */
public class isCompleteTreeAndBinarySearchTree {
    static class Node{
        Node left;
        Node right;
        int val;
        public Node(int val){
            this.val = val;
        }
    }

    /**
     * 判断搜索树，中序遍历
     */
    private static Node prev = null;
    public static boolean inorder(Node root){
        if(root == null) return true;

        if(!inorder(root.left)){
            return false;
        }
        if(prev != null){
            if(root.val <= prev.val){
                return false;
            }
        }
        prev = root;
        return inorder(root.right);
    }

    /**
     * 判断完全二叉树： 层序遍历
     * 1.如果一个结点左右孩子都不为空，则pop该节点，将其左右孩子入队列；
     * 2.如果一个结点左不空，右空，一定不是完全二叉树
     * 3.如果遇到一个结点，左孩子不为空，右孩子为空；或者左右孩子都为空；则该节点之后的队列中的结点都为叶子节点；该树才是完全二叉树，否则就不是完全二叉树；
     * @param root
     * @return
     */
    public static boolean check(Node root){
        if(root == null) return true;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.left == null && node.right != null){
                return false;
            }
            if(node.left != null && node.right != null){
                q.offer(node.left);
                q.offer(node.right);
            }else{
                if(node.left != null){
                    q.offer(node.left);
                }
                while(!q.isEmpty()){
                    Node leaf = q.poll();
                    if(leaf.left != null || leaf.right != null){
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int root = sc.nextInt();
        Node[] nodes = new Node[n + 1];
        nodes[root] = new Node(root);
        sc.nextLine();
        for(int i = 0; i < n; i++){
            int fa = sc.nextInt();
            int lc = sc.nextInt();
            int rc = sc.nextInt();
            nodes[lc] = lc != 0 ? new Node(lc) : null;
            nodes[rc] = rc != 0 ? new Node(rc) : null;
            nodes[fa].left = nodes[lc];
            nodes[fa].right = nodes[rc];
            sc.nextLine();
        }

        System.out.println(inorder(nodes[root]));
        System.out.println(check(nodes[root]));

    }
}
