package wdw.classic.greedy;

/**
 * 给定一个仅包含大写字母的字符串S，可以进行两个操作：
 * 从S开头删除一个，放到T末尾
 * 从S末尾杀出一个，放到T末尾
 * 经可能的构造出字典序小的字符串T
 *
 * 字典序的性质：无论T的末尾有多大，只要保证前面部分较小就可以
 */
public class MinDictionaryOrder {
    public static void main(String[] args) {
        String S = "ACDBCB";
        StringBuilder T = new StringBuilder();

        int a = 0;
        int b = S.length() - 1;
        while(a <= b){
            boolean left = true;
            for(int i = 0; i + a < b; i++){
                if(S.charAt(a + i) < S.charAt(b - i)){
                    left = true;
                    break;
                }else if(S.charAt(a + i) > S.charAt(b - i)){
                    left = false;
                    break;
                }
            }
            if(left)
                T.append(S.charAt(a ++));
            else
                T.append(S.charAt(b --));
        }
        System.out.println(T.toString());
    }
}
