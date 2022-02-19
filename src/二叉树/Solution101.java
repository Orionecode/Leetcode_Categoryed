package 二叉树;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/18 13:25
 * @Filename Solution101
 */

// 递归三部曲
// 1. 确定递归函数的参数和返回值（返回参数bool，参数：左子树，右子树）
// 2. 确定终止条件（先判断左右节点为空的情况，再判断左右节点不为空的情况）
//      1-（左右节点任意一个不为空，不对称）
//      2-（左右节点都为空，对称）
//      3-（左右节点都不为空，判断值，值相等就对称）
// 3. 确定单层递归的逻辑

// 101. 对称二叉树

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return recursive(root, root);
    }

    private boolean recursive(TreeNode root, TreeNode root1) {
        //左右节点都为空，对称
        if (root == null && root1 == null) {
            return true;
        }
        // 左右节点任意一个不为空，不对称
        else if (root == null || root1 == null) {
            return false;
        // 左右节点都不为空，判断值，值相等就对称
        } else if (root.val != root1.val) {
            return false;
        }
        // 最后递归控制
        // 传递左树的左孩子和右树的右孩子，左树的右孩子和右树的左孩子
        return recursive(root.left, root1.right) && recursive(root.right, root1.left);
    }
}
