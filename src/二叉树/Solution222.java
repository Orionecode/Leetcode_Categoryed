package 二叉树;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/18 15:38
 * @Filename Solution222
 */

// 222. 完全二叉树的节点个数
// 本题目递归法思路还是后序深度遍历，将经过的点全部加起来就是答案（与Solution104 高度相似）

public class Solution222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 后续遍历，加上头节点 + 1
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount + rightCount + 1;
    }
}
