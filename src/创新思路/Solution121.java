package 创新思路;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/17 21:03
 * @Filename 创新思路.Solution121
 */

// 121. 买卖股票的最佳时机
// 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

public class Solution121 {
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        // 遍历一次，找到最高价格和最低价格
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
