package wdw.exams.salaries;

import java.util.*;

public class Solution {
    static int num = 19;
    static int[] salaries = {10000,20000,40000,30000,30000,30000,40000,20000,
                            50000,50000,50000,50000,60000,60000,60000,70000,80000,
                            90000,100000};
    public static int[] solution(int num,int[] salaries){
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int[] res = new int[num];
        for(int i = 0; i < num; i ++){
            if(!map.containsKey(salaries[i])){
                map.put(salaries[i],1);
                list.add(salaries[i]);
            }else{
                map.put(salaries[i],map.get(salaries[i]) + 1);
            }
        }
        for(int i = 0; i < list.size() - 1; i ++){
            for(int j = 0; j < list.size() - 1 - i; j ++){
                if (map.get(list.get(j)) < map.get(list.get(j + 1))){
                    int tmp = list.get(j);
                    list.set(j,list.get(j + 1));
                    list.set(j + 1,tmp);
                }
            }
        }
        int strat = 0;
        for(int i = 0; i < list.size(); i ++){
            for(int j = 0; j < map.get(list.get(i)); j++){
                res[strat] = list.get(i);
                strat++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for(int i = 0; i < num; i++){
            System.out.println(solution(num,salaries)[i]);
        }
    }
}
