package BST;

import node.TreeNode;

public class Lc0701__二叉搜索树中的插入操作_2 {

    /**
     * 在二叉树中插入新节点
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val){
        //找到空位置插入新节点
        if (root == null)
            return new TreeNode(val);

        //设置左右子结点
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        return root;
    }

}
