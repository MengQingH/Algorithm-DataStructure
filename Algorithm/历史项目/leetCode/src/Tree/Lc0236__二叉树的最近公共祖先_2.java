package Tree;

import node.TreeNode;

import java.util.Vector;

public class Lc0236__二叉树的最近公共祖先_2 {

    /**
     * 函数定义：给函数提供三个参数root, p, q，它会返回一个结点：
     * 1. 如果p q都在以root为跟的树中，函数返回的是p和q的最近公共结点。
     * 2. 如果p q都不在以root为跟的树中，返回null。
     * 3. 如果p q只有一个存在于以root为跟的树中，就返回那个结点。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        //base case
        if (root == null)
            return null;
        if (root.val == p.val || root.val == q.val)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        /****** 后序遍历位置 ******/   //使用后序遍历，从下网上遍历，得到的结点才是最近的祖先结点
        //情况1 p q都不为空
        if (left != null && right != null)
            return root;
        //情况2 p q都为空
        if (left == null && right == null)
            return null;
        //情况3
        return left == null ? right : left;
    }

}
