package 动态规划;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/12 20:38
 * @Filename 动态规划.Solution221
 */

/*
221. 最大正方形
在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。*/
// 这是一道采用动态规划的题目，我在开始的时候采用的DFS算法，无法通过所有测试用例。
// 采用动态规划算法dp[i][j]中表示的是在右下角能构成的最大正方形
//     如果该位置的值是 1，则dp(i,j) 的值由其上方、左方和左上方的三个相邻位置的 值决定。
//     具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 1
public class Solution221 {
    public static int maximalSquare(char[][] matrix) {
        int res = 0;
        int h = matrix.length;
        int w = matrix[0].length;
        int[][] dp = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }

    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }
}