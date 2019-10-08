package wdw.exams.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strin = scanner.nextLine();
        String[] str = strin.split(";");
        Map<String,Integer> map = new HashMap<>();
        String[] part2 = str[1].split(",");
        for(String s : part2){
            String s1[] = s.split("=");
            map.put(s1[0], Integer.parseInt(s1[1].substring(1,s1[1].length() - 1)));
        }
        
        for(String fun : str[0].split(","));{

        }



    }
}
