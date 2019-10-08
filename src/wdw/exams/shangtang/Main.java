package wdw.exams.shangtang;

import java.util.Scanner;

class Node{
    char val;
    Node next;
    public Node(char val){
        this.val = val;
    }
}

class Buffer{
    private  final  static int N = 8;
    private int size = 0;
    private Node head = null;
    private Node tail = null;
    public Buffer(){

    }
    public void write(String s,int len){
        for(int i = 0; i < len; i++){
            if(size == 0){
                head = tail = new Node(s.charAt(i));
                size++;
                continue;
            }else {
                if (size <= 8) {
                    size++;
                    tail.next = new Node(s.charAt(i));
                    tail = tail.next;
                }
                if (size > 8) {
                    size--;
                    Node p = head;
                    head = head.next;
                    p = null;
                }
            }
        }

    }
    public String read(int len){
        if(len > size)
            len = size;
        StringBuilder sb = new StringBuilder("");
        Node p;
        for(int i = 0; i < len; i++){
            size--;
            sb.append(head.val);
            p = head;
            head = head.next;
            tail.next = new Node('n');
            tail = tail.next;
            p = null;
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Buffer buffer = new Buffer();
        int wlen = sc.nextInt();
        sc.nextLine();
        String wstr = sc.nextLine();
        int rlen = sc.nextInt();
        sc.nextLine();
        buffer.write(wstr,wlen);
        System.out.println(buffer.read(rlen));
    }
}
