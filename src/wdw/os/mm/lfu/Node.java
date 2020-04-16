package wdw.os.mm.lfu;

public class Node {
    int key,val,cnt;
    Node prev,next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
