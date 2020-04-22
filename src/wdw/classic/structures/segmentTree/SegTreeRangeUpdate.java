package wdw.classic.structures.segmentTree;

public class SegTreeRangeUpdate {
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

    /**
     * 懒更新
     */
    public static void down(int[] tree, int[] lazy, int node, int start, int end){
        if(lazy[node] == 0){
            return;
        }
        int leftNode = node * 2 + 1;
        int rightNode = node * 2 + 2;
        int mid = (start + end) / 2;
        tree[leftNode] += (mid - start + 1) * lazy[node];
        lazy[leftNode] += lazy[node];
        tree[rightNode] += (end - mid) * lazy[node];
        lazy[rightNode] += lazy[node];
        lazy[node] = 0;
    }

    /**
     * 区间更新，为区间所有加上一个值，单点更新也要用这个
     */
    public static void update(int[] tree, int[] lazy, int node, int start, int end, int left, int right, int val){
        if(end < left || start > right){
            return ;
        }
        if(start >= left && end <= right){
            lazy[node] += val;
            tree[node] += (end - start + 1) * val;
            return;
        }
        down(tree, lazy, node, start, end);
        int mid = (start + end) / 2;
        int leftNode = node * 2 + 1;
        int rightNode = node * 2 + 2;
        if(right <= mid){
            update(tree, lazy, node, start, mid, left, right, val);
        }else if(left > mid){
            update(tree, lazy, node, mid + 1, end, left, right, val);
        }else{
            update(tree, lazy, node, start, mid, left, right, val);
            update(tree, lazy, node, mid + 1, end, left, right, val);
        }
        tree[node] = tree[leftNode] + tree[rightNode];
    }
    public static int query(int[] tree, int[] lazy, int node, int start, int end, int l, int r){
        if(r < start || l > end){
            return 0;
        }
        if(l <= start && r >= end){
            return tree[node];
        }
        down(tree, lazy, node, start, end); //这里
        int mid = (start + end) / 2;
        int leftNode = node * 2 + 1;
        int rightNode = node * 2 + 2;
        return query(tree, lazy, leftNode, start, mid, l, r) +
                query(tree, lazy, rightNode, mid + 1, end, l, r); //这里，与问题有关
    }

    public static void main(String[] args) {
        int[] nums = {2,4,1,6,4,8,5,43,5,3,1};
        int N = 1;
        while(N < nums.length){
            N <<= 1;
        }
        int[] tree = new int[2 * N - 1];
        int[] lazy = new int[2 * N - 1];
        build(nums,tree,0,0,nums.length - 1);
//        System.out.println(query(nums,tree,0,0,nums.length - 1,3,7));
//        update(nums,tree,0,0,nums.length - 1,4, 0);
//        System.out.println(query(nums,tree,0,0,nums.length - 1,3,7));
    }
}
