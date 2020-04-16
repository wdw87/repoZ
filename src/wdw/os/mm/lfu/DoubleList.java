package wdw.os.mm.lfu;


class DoubleList{
    private Node head, tail;
    int size;

    public DoubleList(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    public void offer(Node x){
        x.next = head.next;
        x.prev = head;
        head.next.prev = x;
        head.next = x;
        size ++;
    }
    public void remove(Node x){
        x.next.prev = x.prev;
        x.prev.next = x.next;
        size --;
    }
    public Node poll(){
        if(tail.prev == head)
            return null;
        tail.prev.prev.next = tail;
        Node last = tail.prev;
        tail.prev = tail.prev.prev;
        size --;
        return last;
    }

}