package wdw.exams.didi;

public class GemGame {
    private static int indexOf(int[] arr,int start,int x){
        while(start < arr.length){
            if(arr[start] == x){
                return start;
            }
            start++;
        }
        return -1;
    }
    private static int recGem(int i,int j,int n,int[] arrA,int[] arrB,int total,int cost){
        if( i == arrA.length || j == arrB.length){
            if(arrA.length - i + arrB.length - j + n * cost > total){
                return 0;
            }else{
                return n;
            }
        }else if(arrA.length - i + arrB.length - j + n * cost > total){
            return n - 1;
        }else{
            int A;
            int B;
            int index = indexOf(arrA,i,arrB[j]);
            if(index > 0){
                A = recGem(index + 1,j + 1,n + 1,arrA,arrB,total,cost);
            }else{
                A = recGem(i,j + 1,n,arrA,arrB,total,cost);
            }
            B = recGem(i,j + 1,n,arrA,arrB,total,cost);
            return Math.max(A,B);
        }
    }
    public static void main(String[] args) {
        int[] arrA = {1,5,4,2,3};
        int[] arrB = {5,4,3,2,1};
        int total = 10000;
        int cost = 1000;
        System.out.println(recGem(0,0,0,arrA,arrB,total,cost));
    }
}
