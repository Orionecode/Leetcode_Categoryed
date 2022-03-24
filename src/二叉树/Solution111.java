package 二叉树;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/18 15:47
 * @Filename Solution111
 */

// 111. 二叉树的最小深度
/*
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明：叶子节点是指没有子节点的节点。
同类型 104. 二叉树的最大深度
*/

// https://mp.weixin.qq.com/s/83ApJOFu4CgTICNRX0hHnA

public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 后序遍历
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        // 从这里开始有个坑，什么是叶子节点？
        // 左右节点都为空的才是叶子节点
        if (root.left == null && root.right != null) {
            // 如果左子树为空，右子树不为空，最小深度为1 + 右子树的最小深度
            return 1 + rightDepth;
        } else if (root.left != null && root.right == null) {
            // 如果右子树为空，左子树不为空，最小深度为1 + 左子树的最小深度
            return 1 + leftDepth;
        }
        // 返回最小深度加1
        return Math.min(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeTool.construct_binary_tree(new int[]{2, -1, 3, -1, 4, -1, 5, -1, 6});
        Solution111 s111 = new Solution111();
        System.out.println(s111.minDepth(root));
    }
}
