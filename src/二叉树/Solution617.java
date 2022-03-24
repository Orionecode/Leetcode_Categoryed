package 二叉树;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/13 18:06
 * @Filename Solution617
 */
/*
617. 合并二叉树
给你两棵二叉树： root1 和 root2 。

想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。

返回合并后的二叉树。
*/
// 本题目有三种情况：
// 1_两个节点都为空，则合并后的二叉树对应的节点也应该为空
// 2_其中一个节点为空，合并后为非空节点
// 3_两个节点都不为空，合并为两个节点相加值
// 深度优先搜索，前序遍历
public class Solution617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 如果t1为空，合并之后就应该是t2
        if (root1 == null) {
            return root2;
        }
        // 如果t2为空，合并之后就应该是t1
        if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeTool.construct_binary_tree(new int[]{1, 3, 2, 5});
        TreeNode root2 = TreeTool.construct_binary_tree(new int[]{2, 1, 3, -1, 4, -1, 7});
        Solution617 solution617 = new Solution617();
        solution617.mergeTrees(root1, root2);
    }
}
