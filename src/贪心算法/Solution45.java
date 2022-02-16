package 贪心算法;

// 45. 跳跃游戏 II
// 贪心算法，每次跳跃到

/**
 * @Author YixiaoZeng
 * @Date 2022/2/10 12:48
 * @Filename Solution45
 */

public class Solution45 {
    public static int jump(int[] nums) {
        // 如果长度是1，无需跳跃
        if (nums.length == 1) {
            return 0;
        }
        // 需要起跳的地方
        int jump = 0;
        // 下一个数能到达的最大下标
        int nextCover = 0;
        // 总步数
        int steps = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            nextCover = Math.max(nextCover, nums[i] + i);
            //说明当前一步，再跳一步就到达了末尾
            if (nextCover >= nums.length) {
                steps++;
                break;
            }
            // 到达需要跳跃的地方
            if (i == jump) {
                steps++;
                // 下一步起跳的地方
                jump = nextCover;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }
}
