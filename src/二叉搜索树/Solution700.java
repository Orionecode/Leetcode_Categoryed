package 二叉搜索树;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/28 16:40
 * @Filename Solution700
 */

// 700. 二叉搜索树中的搜索

public class Solution700 {
    // 递归搜索二叉搜索树
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
