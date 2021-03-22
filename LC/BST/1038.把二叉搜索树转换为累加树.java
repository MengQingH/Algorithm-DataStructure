/*
 * @Author: QingHui Meng
 * @Date: 2021-03-21 15:54:24
 */
/*
 * @lc app=leetcode.cn id=1038 lang=java
 *
 * [1038] 把二叉搜索树转换为累加树
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

    //保存累加值
    private int num = 0;

    /**
     * 方法定义：计算root节点的累加值
     * BST中比一个节点大的值为该节点右边的节点，所以应该从右子树开始计算累加值
     * 
     * @param {TreeNode} root
     * @return {*}
     */
    public TreeNode bstToGst(TreeNode root) {
        //base case
        if(root == null)return null;

        //先从右子树开始
        bstToGst(root.right);

        //计算该节点处的累加值并赋值给节点
        num += root.val;
        root.val = num;

        bstToGst(root.left);

        return root;

    }
}
// @lc code=end

