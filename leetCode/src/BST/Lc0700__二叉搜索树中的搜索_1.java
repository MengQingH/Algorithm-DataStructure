package BST;

import node.TreeNode;

public class Lc0700__二叉搜索树中的搜索_1 {

    /**
     * 相对于普通二叉树的递归，可以利用二叉树的特性，使用二分查找的思想
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val){
        if (root == null)
            return null;

        if (root.val == val)
            return root;
        else if (root.val < val)
            return searchBST(root.right, val);
        else
            return searchBST(root.left, val);
    }

}
