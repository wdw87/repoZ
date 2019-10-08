package wdw.exams.didi;
/**
 * 未完成
 */

import java.util.Arrays;
import java.util.Scanner;
//3 + 2 + 1 + -4 * -5 + 1
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        int[] nums = new int[N];
        StringBuilder stringBuilder = new StringBuilder("");
        for(int i = 0; i < N - 1; i ++){
            nums[i] = scanner.nextInt();
            stringBuilder.append(scanner.next());
        }
        nums[N-1] = scanner.nextInt();
        char[] chars = stringBuilder.toString().toCharArray();

        char c = '/';
        int begin = 0;
        int end = 0;
        for(int i = 0; i < N - 1; i ++){
            if(chars[i] == '*' && c != '*'){
                c = '*';
                begin = i;
                end = i;
            }else if(chars[i] == '*' && c == '*'){
                end++;
            }else if(chars[i] != '*' && c == '*'){
                end ++;
                if(begin > 0 && chars[begin-1] == '/' || end < chars.length && chars[end] == '/'){
                    continue;
                }else{
                    Arrays.sort(nums,begin,end + 1);
                }
                c = '/';
            }

        }
        for(int i = 0; i < N - 1; i ++){
            if(chars[i] == '+' && c != '+'){
                c = '+';
                begin = i;
                end = i;
            }else if( chars[i] == '+' && c == '+'){
                end++;
            }else if(chars[i] != '+' && c == '+'){
                c = '/';
                if(begin > 0 && chars[begin-1] != '+'){
                    begin ++;

                }
                if(begin <= end){
                    Arrays.sort(nums,begin,end + 1);

                }
            }

        }
        if(end == chars.length - 1 && c == '+'){
            if(begin > 0 && chars[begin-1] != '+'){
                begin +=2;

            }
            if(begin <= end){
                Arrays.sort(nums,begin,end + 2);

            }
        }
        for(int i = 0; i < N ; i++){
            System.out.println(nums[i]);
        }
    }
}
