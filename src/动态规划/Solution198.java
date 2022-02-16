package 动态规划;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/14 13:31
 * @Filename Solution198
 */
// Solution191 打家劫舍
// 动态规划题目
// 这道题目的DP方程是将所有偷盗的钱加在一起

public class Solution198 {
    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 开始构建Dp方程
        int[] dp = new int[nums.length];
        // 从最简单的想起，因为Dp方程里面保存的是总金额
        // 如果只有两间房的情况下，dp[1]里面保存的就应该是两间放里面金额较大的那一间
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // 因为 0 1两种情况已经考虑过了，所以这里我们考虑房间数量>=2的情况
        // 如果大于2的情况，dp[i]保存的是打劫到i位置的总金额
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }
}
