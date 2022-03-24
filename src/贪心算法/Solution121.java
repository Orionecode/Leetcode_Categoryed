package 贪心算法;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/17 21:03
 * @Filename 贪心算法.Solution121
 */

// 121. 买卖股票的最佳时机
// 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

public class Solution121 {
    // 贪心算法
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        // 遍历一次，找到最高价格和最低价格，遍历一次，时间复杂度O(n)，空间复杂度O(1)
        for (int i = 1; i < prices.length; i++) {
            // 取右最大值
            profit = Math.max(profit, prices[i] - min);
            // 取左最小值
            min = Math.min(min, prices[i]);
        }
        // 返回最大利润
        return profit;
    }

    // 动态规划，速度不占优势的情况下占用O(n)空间复杂度
    public static int maxDPProfit(int[] prices) {
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
