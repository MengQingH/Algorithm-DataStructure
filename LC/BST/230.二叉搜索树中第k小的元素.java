/*
 * @Author: QingHui Meng
 * @Date: 2021-03-21 15:53:16
 */
/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
     * 利用BST的中序遍历有序的特性来寻找第K小的元素
     * 
     * @param {TreeNode} root
     * @param {int} k
     * @return {*}
     */
    public int kthSmallest(TreeNode root, int k) {
        kthSmallestNum(root, k);
        return res;
    }

    //记录结果
    private int res = 0;
    //记录排位
    private int rank = 0;

    /**
     * 方法定义：元素是否为第K小的元素
     * @param {TreeNode} root
     * @param {int} k
     * @return {*}
     */
    private void kthSmallestNum(TreeNode root, int k){
        //base case
        if(root == null)return;
        
        kthSmallestNum(root.left, k);
        /******** 中序遍历位置 ********/
        rank++;
        if(rank == k){
            res = root.val;
            return;
        }

        kthSmallestNum(root.right, k);
    }
}
// @lc code=end

