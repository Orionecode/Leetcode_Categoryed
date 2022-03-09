package 贪心算法;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/28 15:32
 * @Filename Solution122
 */
/* 本题目和121题目最大的区别是可以对股票进行多次买卖
* */
public class Solution122 {
    // 通过贪心算法计算每天正利润的方式——>总的最大利润
    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int revenue = prices[i] - prices[i - 1];
            if (revenue > 0){
                res += revenue;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
