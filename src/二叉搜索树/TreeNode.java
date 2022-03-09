package 二叉搜索树;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/28 16:45
 * @Filename TreeNode
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}