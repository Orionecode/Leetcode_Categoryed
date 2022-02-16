package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/14 13:54
 * @Filename Solution120
 */

// 120. 三角形最小路径和
// 标准动态规划问题

public class Solution120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        // 设定[0][0]值为三角形尖部
        dp[0][0] = triangle.get(0).get(0);
        // 从第二行开始填写DP
        for (int i = 1; i < n; i++) {
            // 下面这两种数值都是确定的
            // 首先我填写了对角线上的数值
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
            // 然后我填写了每行的第一个的数值
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            // 然后从每行的第二个数值开始填写
            for (int j = 1; j < i; j++) {
                // 因为可以从[i - 1][j]和[i - 1][j - 1]两个位置来填写，所以选择较小的那个
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        }
        // 填写完成dp表格的最后一行就是所有出口的答案，选择最小的那个返回
        int minTotal = dp[n - 1][0];
        for (int i = 0; i < n; i++) {
            minTotal = Math.min(minTotal, dp[n - 1][i]);
        }
        return minTotal;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>() {
            {
                add(new ArrayList<>(Arrays.asList(2)));
                add(new ArrayList<>(Arrays.asList(3, 4)));
                add(new ArrayList<>(Arrays.asList(6, 5, 7)));
                add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));
            }
        };
        System.out.println(minimumTotal(triangle));
    }
}
