package wdw.java.base;

import java.awt.print.Printable;

class Node{
    int key;
    int val;
    Node prev, next;
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

public class DoubleList {
    private Node head;
    private Node tail;
    public DoubleList(){
        Node node = new Node(0,0); //假节点
        head = node;
        tail = node;
    }
    public void offer(Node node){
        tail.next = node;
        node.prev = tail;
        tail = tail.next;
    }
    public Node poll(){
        Node tmp = head;
        Node newHead = tmp.next; //出队的元素成为新的假节点
        if(newHead == null){
            return null;
        }
        head = newHead;
        tmp.next = null;
        head.prev = null;
        return head;
    }
    public void remove(Node node){
        if(node == tail){
            tail = tail.prev;
            tail.next = null;
        }else{
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node node = head;
        while(node.next != null){
            sb.append("[" + node.next.key + "," + node.next.val + "] -> ");
            node = node.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DoubleList list = new DoubleList();
        Node node1 = new Node(1,1);
        Node node2 = new Node(2,2);
        Node node3 = new Node(3,2);
        Node node4 = new Node(4,2);
        Node node5 = new Node(5,2);

        list.offer(node1);
        list.remove(node1);
        list.offer(node2);
        System.out.println(list);
    }
}
