package wdw.exams.anqixing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int len = 0;
        int max = 0;
        int end = 0;
        for(int i =0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                len ++;
            }else{
                if(len > max){
                    max = len;
                    end = i;
                }
                len = 0;
            }
        }
        if(len > max){
            max = len;
            end = s.length();
        }
        System.out.println(max + "/" + s.substring(end - max,end));
    }
}
