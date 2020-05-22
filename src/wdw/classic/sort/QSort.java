package wdw.classic.sort;

import java.util.Arrays;

public class QSort {
    private static void swap(int[] a,int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    /*
    同荷兰国旗问题的方法
     */
    private static int partition(int[] nums, int lo, int hi){
        int ref = nums[lo];
        int left = lo;
        int right = hi;
        int i = left;
        while(i <= right){
            if(nums[i] < ref){
                swap(nums, i, left);
                left ++;
                i ++;
            }else if(nums[i] > ref){
                swap(nums, i, right);
                right --;
            }else{
                i ++;
            }
        }
        return i - 1;
    }
    protected static void sort(int[] a, int lo, int hi){
        if(lo < hi){
            int mid = partition(a,lo,hi);
            sort(a,lo,mid - 1);
            sort(a,mid + 1,hi);
        }
    }
    public static void main(String[] args) {
        int[] a = {54,2,5,7,687,453,24,2,4,6,8,9,7365,9,65,3,0};
        sort(a,0,a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
