/*
 * @Author: Jason Meng
 * @Date: 2021-03-18 15:58:02
 */
/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    /**
     * 方法定义：对当前范围内的nums返回一个最大二叉树，并返回根节点
     * 
     * @param {int[]} nums
     * @param {int} left
     * @param {int} right
     * @return {*}
     */
    public TreeNode construct(int[] nums, int left, int right){
        //base case
        if(left > right)return null;
        
        //找到最大值及其索引
        int max = nums[left];
        int index = left;
        for(int i = left; i <= right; i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            } 
        }

        //根据最大值构造根节点
        TreeNode root = new TreeNode(max);
        //构造根节点的左右子节点
        root.left = construct(nums, left, index-1);
        root.right = construct(nums, index+1, right);
        return root;
    }
}
// @lc code=end

