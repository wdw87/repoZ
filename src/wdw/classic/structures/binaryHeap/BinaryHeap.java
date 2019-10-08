package wdw.classic.structures.binaryHeap;

public class BinaryHeap {

    private int[] arr;
    private int N = 0;

    public BinaryHeap(int capacity){
        arr = new int[capacity + 1];
    }
    private void exch(int x,int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
    private void swim(int k){
        while(k >1 && arr[k/2] < arr[k]){
            exch(k/2,k);
            k /= 2;
        }
    }
    private void sink(int k){
        while(2*k <= N){
            int j = 2*k;
            if(j < N && arr[j] < arr[j + 1])
                j++;
            if(arr[k] > arr[j])
                break;
            exch(k,j);
            k = j;
        }
    }
    public boolean isEmpty(){
        if(N == 0)
            return true;
        return false;
    }
    public void insert(int x){
        arr[++N] = x;
        swim(N);
    }
    public int delMax(){
        int max = arr[1];
        exch(1,N--);
        sink(1);
        return max;
    }
    public int max(){
        return arr[1];
    }
    public static void main(String[] args) {
        BinaryHeap pq = new BinaryHeap(10);
        pq.insert(2);
        pq.insert(6);
        pq.insert(3);
        pq.insert(2);
        pq.insert(2);
        pq.insert(9);
        while(!pq.isEmpty()){
            System.out.println(pq.delMax());
        }
    }
}
