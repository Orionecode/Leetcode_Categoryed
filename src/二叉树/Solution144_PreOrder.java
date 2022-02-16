package 二叉树;

// 144. 二叉树的前序遍历

import java.util.*;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/8 17:24
 * @Filename Solution144_PreOrder
 */

public class Solution144_PreOrder {
    // 非递归方式，使用栈来解决，遍历顺序中左右
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            // 模拟递归的调用，先将所有的根添加到res中，左链入栈
            while (root != null) {
                stack.push(root);
                res.add(root.val);
                root = root.left;
            }
            // ！！！！！到这一步的时候已经为null了，需要将pop出来的值赋给root
            root = stack.pop();
            root = root.right;
        }
        return res;
    }

    // 递归方式，有套路，前序遍历：打印 - 左 - 右
    public List<Integer> preorderTraversalDFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        dfs(res, root.left);
        dfs(res, root.right);
    }
}
