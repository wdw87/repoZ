package wdw.classic.structures.segmentTree;

/**
 * 线段树
 * 以RMQ问题为例，查询某一段的和
 */
public class SegTree {
    public static void build(int[] nums, int[] tree, int node, int start, int end){
        if(start == end){
            tree[node] = nums[start];
        }else{
            int leftNode = node * 2 + 1;
            int rightNode = node * 2 + 2;
            int mid = (start + end) / 2;
            build(nums, tree, leftNode, start, mid);
            build(nums, tree, rightNode, mid + 1, end);
            tree[node] = tree[leftNode] + tree[rightNode];  //这里，与问题有关
        }
    }
    public static void update(int[] nums, int[] tree, int node, int start, int end, int idx, int val){
        if(start == end){
            nums[start] = val;
            tree[node] = val;
        }else{
            int mid = (start + end) / 2;
            int leftNode = node * 2 + 1;
            int rightNode = node * 2 + 2;
            if(idx <= mid){
                update(nums, tree, leftNode, start, mid, idx, val);
            }else{
                update(nums, tree, rightNode, mid + 1, end, idx, val);
            }
            tree[node] = tree[leftNode] + tree[rightNode]; //这里，与问题有关
        }
    }
    public static int query(int[] nums, int[] tree, int node, int start, int end, int l, int r){
        if(r < start || l > end){
            return 0;
        }
        if(l <= start && r >= end){
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftNode = node * 2 + 1;
        int rightNode = node * 2 + 2;
        return query(nums, tree, leftNode, start, mid, l, r) +
                query(nums, tree, rightNode, mid + 1, end, l, r); //这里，与问题有关
    }

    public static void main(String[] args) {
        int[] nums = {2,4,1,6,4,8,5,43,5,3,1};
        int N = 1;
        while(N < nums.length){
            N <<= 1;
        }
        int[] tree = new int[2 * N - 1];
        build(nums,tree,0,0,nums.length - 1);
        System.out.println(query(nums,tree,0,0,nums.length - 1,3,7));
        update(nums,tree,0,0,nums.length - 1,4, 0);
        System.out.println(query(nums,tree,0,0,nums.length - 1,3,7));
    }

}
