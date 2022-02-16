package 二叉树;

// 145. 二叉树的后序遍历

import java.util.*;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/8 19:23
 * @Filename Solution145
 */

public class Solution145_PostOrder {
    // 非递归方式，将先序遍历的顺序调整为中右左，然后翻转极为左右中
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        // 只要栈和节点任意一个不为空
        while (!stack.isEmpty() || root != null) {
            // 模拟递归的调用，不断往右走
            while (root != null) {
                stack.push(root);
                res.add(root.val);
                root = root.right;
            }
            // 返回上一个节点
            root = stack.pop();
            // 去到左边的节点
            root = root.left;
        }
        // 最后翻转
        Collections.reverse(res);
        return res;
    }

    // 递归方式，有套路，后序遍历：左 - 右 - 打印
    public List<Integer> postorderTraversalDFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(res, root.left);
        dfs(res, root.right);
        res.add(root.val);
    }
}
