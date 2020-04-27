package wdw.exams.kuaishou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    private static List<String> res = new ArrayList<>();
    private static double p = -1;
    private static List<String> tmp = new ArrayList<>();


    public static void dfs(String[] s, int index, int cnt1, int cnt2, int prev, int min, int max){
        if(index == s.length){
            if(cnt2 == 0){
                return;
            }
            double pp = (double)cnt1 / (double)cnt2;
            if(pp > p || p < 0){
                p = pp;
                res = new ArrayList<>(tmp);
            }
            return;
        }
        for(int i = index; i < s.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = prev + 1; j <= i; j++){
                sb.append(s[j]);
            }
            String sub = sb.toString();
            tmp.add(sub);
            int len = sub.length();
            if(len >= min && len < max){
                dfs(s, i + 1, cnt1 + 1, cnt2 + 1, i, min, max);
            }else{
                dfs(s, i + 1, cnt1, cnt2 + 1, i, min, max);
            }
            tmp.remove(tmp.size() - 1);
            if(i < s.length - 1)
                dfs(s, i + 1, cnt1, cnt2, prev, min, max);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "/" + sc.next();
        String a = sc.next();
        int smin = sc.nextInt();
        int smax = sc.nextInt();

        dfs(s.split(a), 0, 0, 0, 0, smin, smax);

        for(int i = 0; i < res.size(); i++){
            if(i == res.size() - 1){
                System.out.println(res.get(i));
            }else {
                System.out.print(res.get(i) + " ");
            }
        }
    }
}
