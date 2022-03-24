package 二叉树;

import java.util.*;

// 94. 二叉树的中序遍历

/**
 * @Author YixiaoZeng
 * @Date 2022/2/8 16:37
 * @Filename Solution94
 */

public class Solution94_InOrder {
    // 非递归方式，使用栈来解决，遍历顺序左中右
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            // 模拟递归的调用，不断往左走
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 返回上一个节点
            root = stack.pop();
            // 将节点添加到结果集
            res.add(root.val);
            // 到右边的节点
            root = root.right;
        }
        return res;
    }

    // 递归方式，有套路，中序遍历：左 - 打印 - 右
    public List<Integer> inorderTraversalDFS(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(res, root);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        // 不断的往左走
        dfs(res, root.left);
        // 走不动了，添加到res中
        res.add(root.val);
        // 转向去右边
        dfs(res, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeTool.construct_binary_tree(new int[]{3, 5, 7, 8, 2, 4, 6});
        Solution94_InOrder solution94_inOrder = new Solution94_InOrder();
        System.out.println(solution94_inOrder.inorderTraversalDFS(root));
    }
}
