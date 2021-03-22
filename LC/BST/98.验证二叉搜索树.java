/*
 * @Author: QingHui Meng
 * @Date: 2021-03-21 16:07:22
 */
/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
     * 二叉树的判断不仅仅是对根节点和左右子节点的限定，而是对整个子树的限定。
     * 根节点的值必须大于整个左子树并小于整个右子树
     * 
     * @param {TreeNode} root
     * @return {*}
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * 方法定义：判断一个节点是否符合二叉树的定义
     * 
     * @param {TreeNode} root
     * @param {TreeNode} min
     * @param {TreeNode} max
     * @return {*}
     */
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max){
        //base case
        if(root == null) return true;

        //判断该节点是否符合二叉树的定义
        if(max != null && root.val >= max.val) return false;
        if(min != null && root.val <= min.val) return false;
        //对于左子树来说根节点是最大值，对右子树来说根节点是最小值
        return isValidBST(root.left, min, root) 
                && isValidBST(root.right, root, max);
    }
}
// @lc code=end

