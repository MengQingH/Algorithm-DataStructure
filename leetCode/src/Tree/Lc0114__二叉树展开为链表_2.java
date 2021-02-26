package Tree;

import node.TreeNode;

/**
 * 思路：1. 将root的左子树和右子树拉平。
 *      2. 将root的右子树接到左子树的下方，然后将整个左子树作为右子树。
 */
public class Lc0114__二叉树展开为链表_2 {

    /**
     * 方法定义：给定一个输入结点root，以root为根节点的树会被拉成一条直线
     * @param root
     */
    public void flatten(TreeNode root) {
        //base case
        if(root == null){
            return;
        }

        //需要首先拉平左子树和右子树
        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        TreeNode left = root.left;
        TreeNode right = root.right;

        //把左子树设置为null，把右子树设置为左子树
        root.left = null;
        root.right = left;

        //把右子树连接到左子树末尾
        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }
        p.right = right;
    }

}
