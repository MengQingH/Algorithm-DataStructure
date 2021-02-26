package Tree;

import node.TreeNode;

public class Lc0226__翻转二叉树_1 {

    /**
     * 函数定义：给定一个根结点root，对root的左子树和右子树进行翻转。
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        //base case
        if (root == null) return null;

        /**** 前序遍历位置 ****/
        //交换root结点的左右子结点
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        invertTree(root.left);
        invertTree(root.right);

        return root;

    }

}
