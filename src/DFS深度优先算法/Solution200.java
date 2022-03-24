package DFS深度优先算法;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/11 15:42
 * @Filename DFS深度优先算法.Solution200
 */

public class Solution200 {
    public static int numIslands(char[][] grid) {
        int res = 0;
        int h = grid.length;
        int w = grid[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 未走过并且是1开头的才进行深度搜索
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, visited);
                    res++;
                }
            }
        }
        return res;
    }

    private static void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        // 这里要注意grid[i][j] == '0'条件返回，设定好出口才能AC
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        dfs(grid, i + 1, j, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j - 1, visited);
    }
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
    }
}
