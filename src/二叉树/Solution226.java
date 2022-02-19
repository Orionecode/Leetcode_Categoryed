package 二叉树;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/19 15:09
 * @Filename Solution226
 */

// 226. 翻转二叉树

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        return postOrderDFS(root);
    }

    private TreeNode postOrderDFS(TreeNode root) {
        if (root == null) {
            return root;
        }
        postOrderDFS(root.left);
        postOrderDFS(root.right);
        // Swap Processing
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
