package 几数之和问题;

import java.util.Arrays;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/12 14:02
 * @Filename Solution16
 */

/*16. 最接近的三数之和
给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
返回这三个数的和。
假定每组输入只存在恰好一个解。*/

// ！！！本题目Leetcode官方题解傻逼，请直接跳过

public class Solution16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // Integer.MAX_VALUE要慎重使用，因为可能导致越界
        int res = 100000;
        for (int i = 0; i < nums.length; i++) {
            int one = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = one + nums[left] + nums[right];
                // 本题目是核心就是对比绝对值大小，绝对值越小证明越接近
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return target;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{3, 4, 5, 5, 7}, 13));
    }
}
