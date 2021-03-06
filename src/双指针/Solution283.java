package 双指针;

// 283. 移动零
// 经典双指针问题
// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

import java.util.Arrays;

public class Solution283 {
    public static void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n){
            if (nums[right] != 0){
                swap(nums, left, right);
                left ++;
            }
            right ++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }
}
