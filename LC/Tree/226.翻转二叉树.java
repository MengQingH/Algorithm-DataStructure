/*
 * @Author: QingHui Meng
 * @Date: 2021-03-19 15:24:54
 */
/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /**
     * 方法定义：把root结点的左右子节点进行反转
     * 
     * @param {TreeNode} root
     * @return {*}
     */
    public TreeNode invertTree(TreeNode root) {
        //base case
        if(root == null)
            return null;
        
        /****** 前序遍历位置 ******/
        //交换root的左右子节点
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
// @lc code=end

