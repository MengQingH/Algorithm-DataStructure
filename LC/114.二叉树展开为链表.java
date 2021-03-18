/*
 * @Author: Jason Meng
 * @Date: 2021-03-18 15:42:57
 */
/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
     * 方法定义：给定一个输入结点root，以root为根节点的树会被拉成一条直线
     * 
     * @param {TreeNode} root
     * @return {*}
     */
    public void flatten(TreeNode root) {
        //base case
        if(root == null) return;

        //首先拉平左子树和右子树
        flatten(root.left);
        flatten(root.right);
        
        /* 后序遍历位置 */
        TreeNode left = root.left;
        TreeNode right = root.right;

        //把左子树设置为null，把右子树设置为左子树
        root.right = left;
        root.left = null;

        //把右子树连接到左子树末尾
        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }
        p.right = right;

    }
}
// @lc code=end

