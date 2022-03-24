package 最长连续序列问题;

import java.util.Arrays;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/12 12:48
 * @Filename Solution300
 */
/*300. 最长递增子序列
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。*/


public class Solution300 {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // dp数组中保存的是到下标数字位置递增的位数
        int[] dp = new int[nums.length];
        // 本题目必须先初始化dp数组为1
        Arrays.fill(dp, 1);
        int res = 1;
        // 第0位已经填写，从1开始
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 本题目精华在这里，判断了当前数值大于前面的数值，怎么样找到递增序列
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    System.out.println(Arrays.toString(dp));
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
