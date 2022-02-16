package BFS和DFS;

import java.util.*;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/14 20:59
 * @Filename Solution542
 */
public class Solution542 {
    public int[][] updateMatrix(int[][] mat) {
        /*
         BFS思想, 把所有1都置为最大值, 把所有为0的位置加入队列中, 每次从队列中poll
         一个节点, 更新其四周的节点, 如果被更新的节点距离变小了就将其入队列准备更新其邻接点
         **/
        int m = mat.length;
        if (m < 1) return mat;
        int n = mat[0].length;
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 1)
                    mat[i][j] = Integer.MAX_VALUE;
                else
                    q.offer(new int[]{i, j});
            }
        }

        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int[] dir : dirs) {
                int x = node[0] + dir[0];
                int y = node[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || mat[x][y] <= mat[node[0]][node[1]] + 1)
                    continue;
                mat[x][y] = mat[node[0]][node[1]] + 1;
                q.offer(new int[]{x, y});
            }
        }
        return mat;
    }
}
