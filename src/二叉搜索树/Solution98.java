package 二叉搜索树;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/28 18:05
 * @Filename Solution98
 */
/*
* 对于验证二叉搜索树 有两个陷阱：
陷阱一：不能单纯的比较左节点小于中间节点，右节点大于中间节点就完事了，而是左子树都小于中间节点，右子树都大于中间节点。
陷阱二：一个有序序列求最值的时候，不要定义一个全局遍历，然后遍历序列更新全局变量求最值。因为最值可能就是int 或者 longlong的最小值。*/
// 98. 验证二叉搜索树

public class Solution98 {
    long maxVal = -Long.MAX_VALUE;
// 二叉搜索树「中序遍历」得到的值构成的序列一定是升序的
    public boolean isValidBST(TreeNode root) {
        // 边界条件
        if (root == null) {
            return true;
        }
        // 递归左子树，是否都是
        boolean left = isValidBST(root.left);
        // 中序遍历，可以验证遍历的元素是不是从小到大
        if (maxVal < root.val) {
            maxVal = root.val;
        } else {
            return false;
        }
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
