package wdw.classic.dp;

public class MaxSum {

    private static int[] arr = {1, 2, 4, 1, 7, 8, 3};

    private static int recOpt(int[] arr, int i) {
        if (i == 0) {
            return arr[0];
        } else if (i == 1) {
            return Math.max(arr[0], arr[1]);
        } else {
            int A = recOpt(arr, i - 2) + arr[i];
            int B = recOpt(arr, i - 1);
            return Math.max(A,B);
        }
    }
    private static int dpOpt(int[] arr){
        int[] opt = new int[arr.length];

        opt[0] = arr[0];
        opt[1] = Math.max(arr[0],arr[1]);
        for(int i = 2; i < arr.length; i++){
            int A = opt[i-2] + arr[i];
            int B = opt[i - 1];
            opt[i] = Math.max(A,B);
        }
        return opt[arr.length - 1];
    }

    public static void main(String[] args) {

        System.out.println(recOpt(arr,6));
        System.out.println(dpOpt(arr));

    }
}
