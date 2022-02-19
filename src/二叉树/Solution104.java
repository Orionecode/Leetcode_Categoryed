package 二叉树;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/18 14:38
 * @Filename Solution104
 */

// 注意二叉树的深度和高度的定义！
// 根节点的高度就是二叉树的最大深度

// 104. 二叉树的最大深度
// 给定一个二叉树，找出其最大深度。
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
// 说明: 叶子节点是指没有子节点的节点。

public class Solution104 {
    // 实际上方式跟后序遍历一样
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
