/*
 * @Author: QingHui Meng
 * @Date: 2021-03-21 16:43:36
 */
/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
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
     * 删除值为key的节点，分为以下三种情况：
     * 1. 如果左右节点都为空，那么直接删除；
     * 2. 如果左右子节点有一个不为空，直接返回不为空的子节点；
     * 3. 如果左右子节点都不为空，返回左子树中的最大值或者右子树的最小值。
     * 
     * @param {TreeNode} root
     * @param {int} key
     * @return {*}
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        //base case
        if(root == null)
            return null;

        //首先找到要删除的节点
        if(root.val == key){
            //这两个if把情况1和情况2都处理了
            if(root.left == null ) return root.right;
            if(root.right == null) return root.left;
            //情况3
            TreeNode max = getMax(root.left);
            root.val = max.val;//直接把root节点附上新值
            //删除max节点
            root.left = deleteNode(root.left, max.val);
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else{
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    /**
     * 找到以root为根的树中的最大值
     * 
     * @param {TreeNode} root
     * @return {*}
     */
    private TreeNode getMax(TreeNode root){
        while(root.right != null){
            root = root.right;
        }
        return root;
    }
}
// @lc code=end

