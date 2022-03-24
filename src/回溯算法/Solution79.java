package 回溯算法;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/9 16:37
 * @Filename 回溯算法.Solution79
 */

/*79. 单词搜索
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。*/
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        boolean res;
        if (board == null) return false;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = backtracking(i, j, board, word, visited, 0);  // 从左上角开始遍历棋盘每个格子
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * i,j,board：棋盘格及当前元素的坐标
     * word: 要搜索的目标单词
     * visited：记录当前格子是否已被访问过
     * pos: 记录目标单词的字符索引，只有棋盘格字符和pos指向的字符一致时，才有机会继续搜索接下来的字符；如果pos已经过了目标单词的尾部了，那么便说明找到目标单词了
     */
    public boolean backtracking(int i, int j, char[][] board, String word, boolean[][] visited, int pos) {
        // 超出边界、已经访问过、已找到目标单词、棋盘格中当前字符已经和目标字符不一致了
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]
                || board[i][j] != word.charAt(pos)) {
            return false;
        }

        if (pos == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;  // 修改当前节点状态
        if (backtracking(i + 1, j, board, word, visited, pos + 1) ||  // 遍历子节点
                backtracking(i, j + 1, board, word, visited, pos + 1) ||
                backtracking(i - 1, j, board, word, visited, pos + 1) ||
                backtracking(i, j - 1, board, word, visited, pos + 1)) {
            // 找到了
            return true;
        }
        visited[i][j] = false; // 撤销修改
        // 找不到
        return false;
    }

    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        System.out.println(solution79.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }
}
