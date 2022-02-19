package 二叉树;

import java.util.*;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/18 20:10
 * @Filename Solution102
 */

// 102. 二叉树的层序遍历

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        // 借用一个辅助数据结构即队列来实现
        Deque<TreeNode> queue = new LinkedList<>();
        // 将二叉树的根节点加入到队列中
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                // 返回并删除双端队列的第一个元素。如果双端队列为空，则引发异常。
                TreeNode node = queue.pollFirst();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size --;
            }
            res.add(list);
        }
        return res;
    }
}
