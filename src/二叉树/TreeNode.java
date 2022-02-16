package 二叉树;

// 深度优先遍历：
// 前序遍历(Pre-Order Traversal)
// 中序遍历(In-Order Traversal)
// 后序遍历(Post-Order Traversal)

// 广度优先遍历
// 和深度优先遍历不同，广度优先遍历会先访问离根节点最近的节点。二叉树的广度优先遍历又称按层次遍历。算法借助队列实现。

/**
 * @Author YixiaoZeng
 * @Date 2022/2/8 16:38
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