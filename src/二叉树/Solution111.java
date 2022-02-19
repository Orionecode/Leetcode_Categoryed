package 二叉树;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/18 15:47
 * @Filename Solution111
 */

// https://mp.weixin.qq.com/s/83ApJOFu4CgTICNRX0hHnA

public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        // 从这里开始有个坑，什么是叶子节点？
        // 左右节点都为空的才是叶子节点
        if (root.left == null && root.right != null) {
            return 1 + rightDepth;
        } else if (root.left != null && root.right == null) {
            return 1 + leftDepth;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
