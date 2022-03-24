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
        if (p == null && q == null) {
            // 遍历完成
            return true;
        } else if (p == null || q == null) {
            // p,q任意一个为空节点
            return false;
        } else if (p.val != q.val) {
            // 如果两个节点非空，比较值是否相等
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p = TreeTool.construct_binary_tree(new int[]{1, 2, 3, 4});
        TreeNode q = TreeTool.construct_binary_tree(new int[]{1, 2, 3, -1});
        Solution100 s100 = new Solution100();
        System.out.println(s100.isSameTree(p, q));
    }

}
