package wdw.classic.structures.SkipList;


import java.util.ArrayList;

/**
 * 双向跳表
 */
public class DoubleSkipList {
    private Node head;
    private Node tail;
    private int maxLevel;
    private int size;
    private static final double PROBABILITY = 0.5;
    public DoubleSkipList(){
        this.head = new Node(Integer.MIN_VALUE);
        this.tail = new Node(Integer.MAX_VALUE);
        this.head.nextNodes.add(null);
        this.head.nextNodes.add(tail);
        this.tail.nextNodes.add(head);
        this.maxLevel = 1;
        this.size = 0;
    }
    private static class Node{
        int val;
        ArrayList<Node> nextNodes = null;
        public Node(int val){
            this.val = val;
            nextNodes = new ArrayList<>();
        }
    }
    public void add(int val){
        if(contains(val)) return;
        int level = 1;
        while(Math.random() < PROBABILITY){
            level ++;
        }
        if(level > maxLevel){
            int increment = level - maxLevel;
            while(increment -- >= 0){
                head.nextNodes.add(null);
            }
            maxLevel = level;
        }

        Node newNode = new Node(val);
        for(int i = 0; i <= level; i++){
            newNode.nextNodes.add(null);
        }
        Node curr = head;
        int currLevel = maxLevel;
        while(currLevel >= level){
            if(curr.nextNodes.get(currLevel) != null && curr.nextNodes.get(currLevel).val < val){
                curr = curr.nextNodes.get(currLevel);
            }else{
                currLevel --;
            }
        }
        while(level > 0){
            while(curr.nextNodes.get(level) != null && curr.nextNodes.get(level).val < val){
                curr = curr.nextNodes.get(level);
            }
            newNode.nextNodes.set(level,curr.nextNodes.get(level));
            curr.nextNodes.set(level, newNode);
            level --;
        }
        newNode.nextNodes.get(1).nextNodes.set(0, newNode);
        newNode.nextNodes.set(0, curr);
        size ++;
    }

    public boolean contains(int val){
        if(size == 0) return false;
        int currLevel = maxLevel;
        Node curr = head;
        while(currLevel > 0){
            if(curr.nextNodes.get(currLevel) != null){
                if(curr.nextNodes.get(currLevel).val == val){
                    return true;
                }else if(curr.nextNodes.get(currLevel).val < val){
                    curr = curr.nextNodes.get(currLevel);
                }else{
                    currLevel --;
                }
            }else{
                currLevel --;
            }
        }
        return false;
    }

    public void remove(int val){
        if(!contains(val)) return;
        int currLevel = maxLevel;
        Node curr = head;
        while(currLevel > 0){
            if(curr.nextNodes.get(currLevel) != null){
                if(curr.nextNodes.get(currLevel).val == val){
                    break;
                }else if(curr.nextNodes.get(currLevel).val < val){
                    curr = curr.nextNodes.get(currLevel);
                }else{
                    currLevel --;
                }
            }else{
                currLevel --;
            }
        }
        Node delNode = curr.nextNodes.get(currLevel);
        while(currLevel > 0) {
            while(curr.nextNodes.get(currLevel).val != val){
                curr = curr.nextNodes.get(currLevel);
            }
            curr.nextNodes.set(currLevel, delNode.nextNodes.get(currLevel));
            currLevel --;
        }
        assert currLevel == 0;
        if(delNode.nextNodes.get(currLevel) != null){
            delNode.nextNodes.get(currLevel).nextNodes.set(currLevel, curr);
        }
        size --;
    }

    public static void main(String[] args) {
        DoubleSkipList skipList = new DoubleSkipList();
        skipList.add(3);
        skipList.add(4);
        skipList.add(5);

        System.out.println(skipList.contains(2));
        System.out.println(skipList.contains(3));
        skipList.remove(3);
        System.out.println(skipList.contains(3));
        System.out.println(skipList.contains(4));
    }

}
