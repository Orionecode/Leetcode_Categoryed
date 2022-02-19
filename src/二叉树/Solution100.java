package 二叉树;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/19 14:55
 * @Filename Solution100
 */

// 100. 相同的树
/*    给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
    如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。*/


public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return recursive(p, q);
    }

    private boolean recursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q == null) {
            return false;
        } else if (p == null && q != null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return recursive(p.left, q.left) && recursive(p.right, q.right);
    }
}
