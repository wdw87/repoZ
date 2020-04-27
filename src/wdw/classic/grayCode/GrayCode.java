package wdw.classic.grayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成格雷码
 */
public class GrayCode {
    //递归的思路就是n位gray码是由n-1位gray码生成，举个例子简单一些：
    //比如求n=3的gray码，首先知道n=2的gray码是(00,01,11,10)
    //那么n=3的gray码其实就是对n=2的gray码首位添加0或1生成的，添加0后变成(000,001,011,010)
    //添加1后需要顺序反向就变成(110,111,101,100)
    //组合在一起就是(000,001,011,010,110,111,101,100)
    public static List<String> getGrayCode(int n){
        List<String> list = new ArrayList<>();
        if(n == 1){
            list.add("0");
            list.add("1");

        }else {
            List<String> last = getGrayCode(n - 1);
            for (int i = 0; i < last.size(); i++) {
                list.add("0" + last.get(i));
            }
            for (int i = last.size() - 1; i >= 0; i--) {
                list.add("1" + last.get(i));
            }
        }
        return list;
    }
    public static void main(String[] args) {
        List<String> gray = getGrayCode(3);
        System.out.println(gray);
    }
}
