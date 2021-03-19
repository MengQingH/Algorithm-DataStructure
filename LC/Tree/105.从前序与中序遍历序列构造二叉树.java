/*
 * @Author: QingHui Meng
 * @Date: 2021-03-18 17:13:15
 */
/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    /**
     * 方法定义：对给定范围内的前序和中序遍历序列来构造根节点并返回
     * 
     * @param {int[]} preOrder
     * @param {int} preStart
     * @param {int} preEnd
     * @param {int[]} inOrder
     * @param {int} inStart
     * @param {int} inEnd
     * @return {*}
     */
    private TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd){
        //base case
        if(preStart > preEnd)
            return null;
        
        //前序遍历的第一个值就是根节点
        int rootValue = preOrder[preStart];

        //找出根节点在中序遍历序列中的索引，方便确定递归的范围
        int index = 0;//索引默认值要设置为0
        for(int i = inStart; i<=inEnd; i++){
            if(inOrder[i] == rootValue){
                index = i;
                break;
            }
        }

        //求出左子树的长度，方便确定递归的范围
        //（左子树的起点+左子树的长度  该位置处的结点应该是左子树后的第一个结点；左子树的起点+左子树长度-1  才是左子树的最后一个结点）
        int leftSize = index - inStart;

        //构造根节点，并递归构造根节点的左子树和右子树
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(preOrder, preStart+1, preStart+leftSize, inOrder, inStart, index-1);
        root.right = buildTree(preOrder, preStart+leftSize+1, preEnd, inOrder, index+1, inEnd);
        
        return root;
    }
}
// @lc code=end

