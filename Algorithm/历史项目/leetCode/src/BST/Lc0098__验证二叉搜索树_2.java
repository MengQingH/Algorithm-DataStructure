package BST;

import node.TreeNode;

public class Lc0098__验证二叉搜索树_2 {

    public boolean isValidBST(TreeNode root){
        return isValidBST(root, null, null);
    }

    /**
     * 限定以root为跟的子树结点必须满足max.val > root.val > min.val
     * @param root
     * @param max
     * @param min
     * @return
     */
    private boolean isValidBST(TreeNode root, TreeNode max, TreeNode min){
        //base case
        if (root == null)
            return true;

        //如果root.val不满足max和min的限制，说明不是合法的BST
        if (max != null && root.val >= max.val) return false;
        if (min != null && root.val <= min.val) return false;

        //root的左子树最大值是root.val，root的右子树最小值是root.val
        return isValidBST(root.left, root, min)
                && isValidBST(root.right, max, root);
    }

}
