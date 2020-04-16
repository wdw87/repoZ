package wdw.os.mm.lfu;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    int cap;
    int minCnt = 0;
    Map<Integer, Node> map = new HashMap<>();
    Map<Integer, DoubleList> cntMap = new HashMap<>();
    DoubleList list = new DoubleList();
    public LFUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        if(cap == 0){
            return -1;
        }
        if(map.containsKey(key)){

            Node node = map.get(key);
            DoubleList list = cntMap.get(node.cnt);
            list.remove(node);
            if(list.size == 0){
                cntMap.remove(node.cnt);
                if(node.cnt == minCnt){
                    minCnt ++;
                }
            }

            node.cnt ++;
            if(!cntMap.containsKey(node.cnt)){
                cntMap.put(node.cnt, new DoubleList());
            }
            list = cntMap.get(node.cnt);
            list.offer(node);

            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cap == 0){
            return;
        }
        if(map.containsKey(key)){
            get(key);
            Node node = map.get(key);
            node.val = value;
            return;
        }
        Node newNode = new Node(key,value);
        if(map.size() == cap){
            DoubleList list = cntMap.get(minCnt);
            Node node = list.poll();
            if(list.size == 0){
                cntMap.remove(node.cnt);
                if(node.cnt == minCnt){
                    minCnt ++;
                }
            }
            map.remove(node.key);
        }
        if(!cntMap.containsKey(newNode.cnt)){
            cntMap.put(newNode.cnt, new DoubleList());
        }
        DoubleList list = cntMap.get(newNode.cnt);
        list.offer(newNode);
        map.put(key, newNode);
        minCnt = Math.min(minCnt, newNode.cnt);

    }
    public static void main(String[] args) {

    }
}
