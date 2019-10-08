package wdw.classic.sort;

import java.util.Arrays;

public class QSort {
    private static void exch(int[] a,int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    private static int partition(int[] a, int lo, int hi){
        int i = lo,j = hi + 1;
        while(true){
            while(a[++i] < a[lo]){
                if(i == hi)
                    break;
            }
            while(a[lo] < a[--j]){
                if(j == lo)
                    break;
            }
            if(i >= j)
                break;

            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
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
