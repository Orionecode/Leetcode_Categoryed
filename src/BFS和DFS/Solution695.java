package BFS和DFS;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/14 19:48
 * @Filename Solution695
 */
public class Solution695 {
    public static int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        // 从第一排开始查找
        for (int i = 0; i <= grid.length; i++) {
            // 在每一行中寻找陆地，等于1
            for (int j = 0; j <= grid[0].length; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    private static int dfs(int[][] grid, int x, int y) {
        // 处理边界！！！！
        // 这是最关键的一步，里面的||具有先后顺序
        // x < 0和y < 0两种情况直接排除，然后遍历到边界要退出，x == grid.length || y == grid[0].length
        // 如果前面的都满足再看是否是陆地
        if (x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] != 1) {
            return 0;
        }
        // 走过的地方置0
        grid[x][y] = 0;
        // 在这里至少答案都为1，因为有陆地才会进入dfs
        int res = 1;
        // 向四个方向发散求和
        res += dfs(grid, x - 1, y);
        res += dfs(grid, x + 1, y);
        res += dfs(grid, x, y - 1);
        res += dfs(grid, x, y + 1);
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
