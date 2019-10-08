package wdw.classic.structures.binaryHeap;

import java.util.Arrays;

public class HeapSort {
    public static void swap(int[] a, int x, int y) {
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

    public static void heapify(int[] arr, int p, int N) {
        if (p >= N) return;
        int c1 = (p + 1) * 2 - 1;
        int c2 = (p + 1) * 2;
        int min = p;
        if (c1 < N && arr[c1] > arr[min])
            min = c1;
        if (c2 < N && arr[c2] > arr[min])
            min = c2;
        if (p != min) {
            swap(arr, p, min);
            heapify(arr,min,N);
        }
    }

    public static void buildHeap(int[] arr, int N) {
        int lastParent = N / 2 - 1;
        for (int i = lastParent; i >= 0; i--) {
            heapify(arr, i, N);
        }
    }

    public static void heapifySort(int[] arr) {
        for (int i = arr.length; i > 0; i--) {
            buildHeap(arr,i);
            swap(arr,0,i - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 8, 3, 6, 98, 65, 123, 6, 87, 2};
        heapifySort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
