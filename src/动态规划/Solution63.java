package 动态规划;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/9 16:14
 * @Filename Solution63
 */

// 63. 不同路径 II
// 一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。

// 这道题读题非常重要，因为机器人只能往下走和往右走
// 所以某个格子是障碍物，那么与他平行或者垂直的格子均无法到达

public class Solution63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 行长度
        int m = obstacleGrid.length;
        // 列长度
        int n = obstacleGrid[0].length;
        // DP函数
        int[][] dp = new int[m][n];
        // 判断入口处是否有障碍物
        dp[0][0] = (obstacleGrid[0][0] == 1) ? 0 : 1;
        // 处理列
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                // 如果某个格子是障碍物，则后面都无法到达，直接退出循环
                break;
            } else {
                //
                dp[i][0] = 1;
            }
        }
        // 处理行
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                // 如果某个格子是障碍物，则后面都无法到达，直接退出循环
                break;
            } else {
                //
                dp[0][i] = 1;
            }
        }
        for (int k = 1; k < m; k++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[k][j] == 1) {
                    dp[k][j] = 0;
                } else {
                    dp[k][j] = dp[k - 1][j] + dp[k][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0}}));
    }
}
