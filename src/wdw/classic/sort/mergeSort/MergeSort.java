package wdw.classic.sort.mergeSort;

public class MergeSort {

    public static void merge(int[] a, int[] aux, int lo, int hi, int mid){

        for(int i = lo; i < hi; i ++){
            aux[i] = a[i];
        }
        int i = lo, j = mid;
        for(int k = lo; k < hi; k ++){
            if(i >= mid) a[k] = aux[j++];
            else if(j >= hi) a[k] = aux[i++];
            else if(aux[j] < aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }

    }

    public static void sort(int[] a,int[] aux,int lo,int hi){
        if(lo >= hi - 1) return;
        int mid = lo + (hi - lo) / 2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid,hi);
        merge(a,aux,lo,hi,mid);
    }

    public static void main(String[] args) {
        int[] a = {4,2,9,5,4,8,8};
        int[] aux = new int[a.length];
        sort(a,aux,0,a.length);


        for(int i = 0; i < a.length; i ++){
            System.out.print(a[i] + " ");
        }
    }

}
