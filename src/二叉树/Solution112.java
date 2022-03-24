package 二叉树;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/2 10:54
 * @Filename Solution112
 */

/*
再来看返回值，递归函数什么时候需要返回值？什么时候不需要返回值？这里总结如下三点：
如果需要搜索整颗二叉树且不用处理递归返回值，递归函数就不要返回值。（这种情况就是本文下半部分介绍的113.路径总和ii）
如果需要搜索整颗二叉树且需要处理递归返回值，递归函数就需要返回值。（这种情况我们在236. 二叉树的最近公共祖先介绍）
如果要搜索其中一条符合条件的路径，那么递归一定需要返回值，因为遇到符合条件的路径了就要及时返回。（本题的情况）
*/

/*112. 路径总和
给你二叉树的根节点 root 和一个表示目标和的整数 sum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 sum 。如果存在，返回 true ；否则，返回 false 。
叶子节点 是指没有子节点的节点。*/

public class Solution112 {
    // 用减法来判断是否存在路径
    public boolean hasPathSum(TreeNode root, int sum) {
        // 1.确定终止条件
        if (root == null) {
            return false;
        }
        // 左右子节点均为空 检查sum是否等于root的值
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        // 2.确定单层递归逻辑
        // 本题目和100题一样，必须同时写，分开写递归函数会测试用例不通过
        // 返回左右节点都可以
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
