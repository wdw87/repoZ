package wdw.classic.structures.SkipList;

import java.util.ArrayList;

/**
 * 跳跃表
 * 查找，插入，删除 都为 O(logn)
 * 空间复杂度为o(n)
 */
public class SkipList {
    private Node head;
    private int maxLevel;
    private int size;
    private static final double PROBABILITY = 0.5;
    private class Node{
        int val;
        ArrayList<Node> nextNodes = null;
        public Node(int val){
            this.val = val;
            nextNodes = new ArrayList<>();
        }
    }
    public SkipList(){
        this.head = new Node(Integer.MIN_VALUE);
        //初始化跳表的0层始终为null
        this.head.nextNodes.add(null);
        this.maxLevel = 0;
        this.size = 0;
    }

    public void add(int val){
        if(contains(val)){
            return;
        }
        //确定新节点的层数
        int level = 1;
        while(Math.random() < PROBABILITY){
            level ++;
        }
        //如果新节点的层数大于最高层数，先将头节点增高
        if(level > maxLevel){
            int increment = level - maxLevel;
            while(increment-- > 0){
                head.nextNodes.add(null);
            }
            maxLevel = level;
        }
        //创建新节点
        Node newNode = new Node(val);
        //寻找新节点的插入位置
        Node curr = findInsertionOfTopLevel(val, level);
        while (level > 0){
            //新节点与后边的节点连接
            if(curr.nextNodes.get(level) != null){
                newNode.nextNodes.add(0, curr.nextNodes.get(level));
            }else{
                newNode.nextNodes.add(0, null);
            }
            //当前节点的next指向新节点
            curr.nextNodes.set(level, newNode);
            //层数降低，新节点的每层都要与前后节点相连
            level --;
            //寻找下一层需要连接的地方
            while(curr.nextNodes.get(level) != null && curr.nextNodes.get(level).val < val){
                curr = curr.nextNodes.get(level);
            }
        }
        //最后，保证节点的0层始终为null
        newNode.nextNodes.add(0, null);
        size ++;
    }

    private Node findInsertionOfTopLevel(int newVal, int level){
        int currLevel = maxLevel;
        Node curr = head;
        while(currLevel >= level){
            //尝试向右寻找
            if(curr.nextNodes.get(currLevel) != null && curr.nextNodes.get(currLevel).val < newVal){
                curr = curr.nextNodes.get(currLevel);
            }else{
                //向下寻找
                currLevel --;
            }
        }
        return curr;
    }
    public boolean contains(int val){
        if(size == 0){
            return false;
        }
        int level = maxLevel;
        Node curr = head;
        while(level > 0){
            if(curr.nextNodes.get(level) != null){
                if(curr.nextNodes.get(level).val < val){
                    curr = curr.nextNodes.get(level);
                }else if(curr.nextNodes.get(level).val == val){
                    return true;
                }else{
                    level --;
                }
            }else{
                level --;
            }
        }
        return false;
    }

    public void remove(int val){
        if(contains(val)){
            //一定存在，每次都从Head的最高层开始遍历
            Node curr = head;
            int level = maxLevel;
            //寻找要删除的节点
            while (level > 0){
                if(curr.nextNodes.get(level) != null){
                    //向右寻找
                    if(curr.nextNodes.get(level).val < val) {
                        curr = curr.nextNodes.get(level);
                    }else if(curr.nextNodes.get(level).val == val){ //找到了
                        curr = curr.nextNodes.get(level);
                        break;
                    }else{
                        //本层没有找到，到下一层找
                        level --;
                    }
                }else{
                    //本层没有找到，到下一层找
                    level --;
                }
            }
            //寻找要删除的节点的前驱节点,每一层都要断开与被删除节点的连接
            while(level > 0){
                Node pre = head;
                //向右寻找
                while(pre.nextNodes.get(level).val != val){
                    pre = pre.nextNodes.get(level);
                }
                pre.nextNodes.set(level, curr.nextNodes.get(level));
                level --;
            }
            size --;
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
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
