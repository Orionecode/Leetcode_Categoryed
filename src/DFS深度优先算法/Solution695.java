package DFS深度优先算法;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/14 19:48
 * @Filename Solution695
 */

/*给你一个大小为 m x n 的二进制矩阵 grid 。
岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
岛屿的面积是岛上值为 1 的单元格的数目。
计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。*/

public class Solution695 {
    public static int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int h = grid.length;
        int w = grid[0].length;
        boolean[][] visited = new boolean[h][w];
        // 从第一排开始查找
        for (int i = 0; i < h; i++) {
            // 在每一行中寻找陆地，等于1
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j, visited));
                }
            }
        }
        return ans;
    }

    private static int dfs(int[][] grid, int x, int y, boolean[][] visited) {
        // 处理边界！！！！
        // 这是最关键的一步，里面的||具有先后顺序
        // 如果前面的都满足再看是否是陆地
        // 如果是采用visited数组，dfs中必须判断grid[x][y]是否等于0，遇到边界了就要及时返回
        if (x < 0 || y < 0 || x == grid.length || y == grid[0].length || visited[x][y] || grid[x][y] == 0) {
            return 0;
        }
        // 走过的地方设置为true
        visited[x][y] = true;
        // 在这里至少答案都为1，因为有陆地才会进入dfs
        int res = 1;
        // 向四个方向发散求和
        res += dfs(grid, x + 1, y, visited);
        res += dfs(grid, x, y + 1, visited);
        res += dfs(grid, x - 1, y, visited);
        res += dfs(grid, x, y - 1, visited);
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
