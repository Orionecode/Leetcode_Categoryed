package 双指针;

// 167. 两数之和 II - 输入有序数组

// 经典双指针问题，利用非递减顺序排列数组的性质来判断离target的距离
// 如果大于Target把右指针--，小于则把左指针右移动
// 给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。

import java.util.Arrays;

public class Solution167 {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
//        在整个移动过程中，左指针不可能移到 right 的右侧，右指针不可能移到 left 的左侧
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
    }
}
