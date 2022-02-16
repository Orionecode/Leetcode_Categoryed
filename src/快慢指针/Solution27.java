package 快慢指针;

// 27. 移除元素
// 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
// 使用快慢指针法效率较高

import java.util.Arrays;

public class Solution27 {
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }
        int slow = 0;
        int fast = 0;
        // 使用while循环需要注意的是下标问题，如果先加fast，不仅nums[0]无法判断，而且会下标越界
        // 记得在末尾加上1 fast ++ = 8时已不满足条件
        while(fast < nums.length){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }
        // 使用for循环同理
//        for (; fast < nums.length; fast ++){
//            if (nums[fast] != val){
//                nums[slow] = nums[fast];
//                slow ++;
//            }
//        }
        System.out.println(Arrays.toString(nums));
        return slow;
    }


    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{2}, 3));
    }
}
