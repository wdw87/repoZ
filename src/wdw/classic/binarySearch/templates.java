package wdw.classic.binarySearch;

/**
 * 查找方式	        循环条件	    左侧更新	    右侧更新	        中间点位置	            返回值
 * 标准二分查找	left <= right	left = mid - 1	right = mid + 1	    (left + right) / 2	        -1 / mid
 * 二分找左边界	left < right	left = mid - 1	right = mid	        (left + right) / 2	        -1 / left
 * 二分找右边界	left < right	left = mid	    right = mid - 1	    (left + right) / 2 + 1	    -1 / right
 */
public class templates {
    //标准二分
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意
        while(left <= right) { // 注意
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }
    //找左边界
    int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }
    //找右边界
    int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1; // 注意
    }
}
