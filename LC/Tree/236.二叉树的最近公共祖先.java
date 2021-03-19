/*
 * @Author: QingHui Meng
 * @Date: 2021-03-19 14:41:50
 */
/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    /**
     * 函数定义：给函数提供三个参数root, p, q，它会返回一个结点：
     * 1. 如果p q都在以root为跟的树中，函数返回的是p和q的最近公共结点。
     * 2. 如果p q都不在以root为跟的树中，返回null。
     * 3. 如果p q只有一个存在于以root为跟的树中，就返回那个结点。
     * 
     * @param {TreeNode} root
     * @param {TreeNode} p
     * @param {TreeNode} q
     * @return {*}
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(root == null)
            return null;
        if(root.val == p.val || root.val == q.val)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        /******** 后序遍历位置 ********/
        //情况1 left right都不为空   ---root结点为p q的最近公共祖先结点
        if(left != null && right != null)
            return root;
        //情况2 left right都为空     ---p q都不为root的子结点
        if(left == null && right == null)
            return null;
        //情况3 left right只有一个为空 ---该节点要么是p和q，要么是最近公共祖先结点
        return left == null ? right : left; 
    }
}
// @lc code=end

