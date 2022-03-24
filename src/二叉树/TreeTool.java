package 二叉树;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/14 16:22
 * @Filename construct_binary_tree
 */
// 二叉树本地调试工具
public class TreeTool {
    // 构建二叉树
    public static TreeNode construct_binary_tree(int[] list) {
        TreeNode[] listTree = new TreeNode[list.length];
        // 根节点（实际上是根节点的指针）
        TreeNode root = null;
        for (int i = 0; i < list.length; i++) {
            TreeNode node = null;
            // 用-1表示null
            if (list[i] != -1) {
                // 此处不为空则将node赋值
                node = new TreeNode(list[i]);
            }
            listTree[i] = node;
            // i == 0为根节点
            if (i == 0) {
                root = node;
            }
        }
        // 结束规则是 i * 2 + 2 < list.length，避免空null
        for (int i = 0; i * 2 + 2 < list.length; i++) {
            if (listTree[i] != null) {
                // 将线性存储改为链式存储
                listTree[i].left = listTree[i * 2 + 1];
                listTree[i].right = listTree[i * 2 + 2];
            }
        }
        return root;
    }
}
