package 快慢指针;

// 26. 删除有序数组中的重复项
// 这道题目的关键就是在"有序"

import java.util.Arrays;

public class Solution26 {
    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length){
            if (nums[slow] != nums[fast]){
                nums[slow + 1] = nums[fast];
                slow ++;
            }
            while (fast < nums.length && nums[slow] == nums[fast]){
                fast ++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return slow + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
