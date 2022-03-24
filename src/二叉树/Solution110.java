package 二叉树;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/16 16:08
 * @Filename Solution110
 */

/*
110. 平衡二叉树
给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
本题目和104题结合使用
*/

// 二叉树节点的深度：指从根节点到该节点的最长简单路径边的条数。(从上往下)
// 二叉树节点的高度：指从该节点到叶子节点的最长简单路径边的条数。(从下往上)
// 这里我们考虑后序遍历的方式，自底向上的递归

public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) == -1 ? false : true;
    }

    private int getDepth(TreeNode root) {
        // 终止条件
        if (root == null) {
            return 0;
        }
        // 如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），否则返回 −1。
        int leftD = getDepth(root.left);
        if (leftD == -1) {
            return -1;
        }
        int rightD = getDepth(root.right);
        if (rightD == -1) {
            return -1;
        }
        // 返回结果，整个左右子树是否高度差只有1
        return Math.abs(leftD - rightD) > 1 ? -1 : 1 + Math.max(leftD, rightD);
    }
}
