package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/2 11:35
 * @Filename Solution113
 */

/*113. 路径总和 II
给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
回溯算法
叶子节点 是指没有子节点的节点。*/

public class Solution113 {
    // 路径总和ii要遍历整个树，找到所有路径，所以递归函数不要返回值！
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        backTrack(root, targetSum);
        return res;
    }

    private void backTrack(TreeNode root, int targetSum) {
        // 1.确定终止条件
        // 遇到空节点 直接返回
        if (root == null) {
            return;
        }
        // 2.确定递归函数部分
        // 在链表尾部插入数据
        path.offerLast(root.val);
        targetSum -= root.val;
        // 遇到了叶子节点且找到了和为sum的路径
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<>(path));
        }
        backTrack(root.left, targetSum);
        backTrack(root.right, targetSum);
        // Deque接口扩展(继承)了 Queue 接口。在将双端队列用作队列时，将得到 FIFO（先进先出）行为。
        // 这里用pullLast返回并删除最后一个元素
        path.pollLast();
    }
}
