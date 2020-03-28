package wdw.classic.other;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 */
public class 摩尔投票 {
    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public static int moore(int[] nums){
        int count = 0;
        int num = 0;
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                num = nums[i];
                count = 1;
            }else if(num == nums[i]){
                count ++;
            }else{
                count --;
            }
        }
        return num;
    }

    /**
     * 排序法
     * @param nums
     * @return
     */
    public static int sort(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
