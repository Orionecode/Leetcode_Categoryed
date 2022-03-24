package 二叉搜索树;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/12 13:49
 * @Filename Solution96
 */
public class Solution96 {
    public static int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
