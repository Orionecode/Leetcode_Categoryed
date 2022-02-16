package 贪心算法;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/9 21:20
 * @Filename Solution55
 */

// 思路：不用考虑每一步跳跃到那个位置，而是尽可能的跳跃到最远的位置，看最多能覆盖的位置，不断更新能覆盖的距离。
// 复杂度：时间复杂度O(n)，遍历一边。空间复杂度O(1)

public class Solution55 {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        // 能到的最远位置
        int rightMost = 0;
        for (int i = 0; i < n; ++i) {
            // ！！！确保当前下标不会超过最右下标
            if (i <= rightMost)
                // 贪心算法，比较现在能到的最远位置和之前的最远位置
                rightMost = Math.max(rightMost, i + nums[i]);
                // 如果最远位置大于等于数组最后一个下标就返回True
                if (rightMost >= n - 1) {
                    return true;
                }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
