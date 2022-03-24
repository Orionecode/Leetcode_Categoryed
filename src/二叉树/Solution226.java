package 二叉树;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/19 15:09
 * @Filename Solution226
 */

// 226. 翻转二叉树

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 深度DFS后序遍历，从底部向上交换
        invertTree(root.left);
        invertTree(root.right);
        // 开始交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 最后返回
        return root;
    }
}
