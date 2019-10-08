package wdw.classic.dp;

public class SubSetSum {

    private static int[] arr = {3, 34, 4, 12, 5, 2};

    private static boolean recSubset(int[] arr, int i, int s) {
        if (i == 0)
            return arr[0] == s;
        else if (s == 0)
            return true;
        else {
            boolean A = recSubset(arr, i - 1, s - arr[i]);
            boolean B = recSubset(arr, i - 1, s);
            return A || B;
        }
    }

    private static boolean dpSubset(int[] arr, int s) {
        boolean[][] subset = new boolean[arr.length][s + 1];
        for (int i = 0; i < arr.length; i++) {
            subset[i][0] = true;
        }
        for (int i = 0; i < s; i++) {
            subset[0][i] = arr[0] == i;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= s; j++) {
                if(j-arr[i] < 0)
                    subset[i][j] = subset[i-1][j];
                else {
                    boolean A = subset[i - 1][j - arr[i]];
                    boolean B = subset[i - 1][j];
                    subset[i][j] = A || B;
                }
            }
        }
        return subset[arr.length - 1][s];
    }

    public static void main(String[] args) {
        System.out.println(dpSubset(arr, 9));
        System.out.println(dpSubset(arr, 10));
        System.out.println(dpSubset(arr,  11));
        System.out.println(dpSubset(arr, 12));

        System.out.println(dpSubset(arr,  13));

    }

}
