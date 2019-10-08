package wdw.exams.kmp;

import java.util.Arrays;

public class KMPTest {
    public static int[] getNext(String ps) {
        char[] strKey = ps.toCharArray();
        int[] next = new int[strKey.length];

        int j = 0;
        int k = -1;
        next[0] = -1;
        while (j < strKey.length - 1) {
            if (k == -1 || strKey[j] == strKey[k]) {
                if (strKey[j + 1] == strKey[k + 1]) {
                    next[++j] = next[++k];
                } else {
                    next[++j] = ++k;
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }
    public static int[] getNext2(String ps) {
        char[] strKey = ps.toCharArray();
        int[] next = new int[strKey.length];

        int j = 0;
        int k = -1;
        next[0] = -1;
        while (j < strKey.length - 1) {
            if (k == -1 || strKey[j] == strKey[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void kmp(String tS,String pS){
        char[] t = tS.toCharArray();
        char[] p = pS.toCharArray();
        int i = 0;
        int j = 0;
        int[] next = getNext(pS);
        while( i < t.length && j < p.length){

            if(j == -1 || t[i] == p[j]){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j == p.length)
            System.out.println(i - j);
        else{
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        String pStr = "aaaab";
        System.out.println(Arrays.toString(getNext2(pStr)));
        System.out.println(Arrays.toString(getNext(pStr)));
        kmp("aaabaaaab","aaaab");
    }
}
