/*
 * @Author: QingHui Meng
 * @Date: 2021-03-19 11:02:10
 */
/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    /**
     * 方法定义：对范围内的中序和后序遍历序列，找出根节点并返回
     * 
     * @param {int[]} inOrder
     * @param {int} inStart
     * @param {int} inEnd
     * @param {int[]} postOrder
     * @param {int} postStart
     * @param {int} postEnd
     * @return {*}
     */
    private TreeNode buildTree(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd){
        //base case
        if(inStart > inEnd)
            return null;
        
        //根据后序遍历的定义，根节点的值是后序遍历的最后一个值
        int rootValue = postOrder[postEnd];

        //找出根节点在中序遍历中的位置
        int index = 0;
        for(int i=inStart; i<=inEnd; i++){
            if(inOrder[i] == rootValue){
                index = i;
                break;
            }
        }

        //求出左子树的长度
        //（左子树的起点+左子树的长度  该位置处的结点应该是左子树后的第一个结点；左子树的起点+左子树长度-1  才是左子树的最后一个结点）
        int leftSize = index - inStart;

        //构造根节点并递归构造根节点的左右子树
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(inOrder, inStart, index-1, postOrder, postStart, postStart+leftSize-1);
        root.right = buildTree(inOrder, index+1, inEnd, postOrder, postStart+leftSize, postEnd-1);
        return root;
    }
}
// @lc code=end

