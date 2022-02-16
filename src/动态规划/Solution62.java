package 动态规划;

// 62. 不同路径
// 动态规划

public class Solution62 {
    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0){
            return 0;
        }
//        步骤一：定义数组元素的含义
//        机器人可以通过m - 1或者 n - 1两个点向下或者向右移动一格来到达终点
        int[][] dp = new int[m][n];
//        步骤二：找出关系数组元素间的关系式
//        一种是从 (i-1, j) 这个位置走一步到达
//        一种是从(i, j - 1) 这个位置走一步到达
//        两个位置累计的走法加起来就是所有的走法
//        步骤三：找出初始值，因为有m，n有一个为0的时候，就只能有一种走法了，故现在开始初始化
        for (int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }
}
