/*
 * @Author: QingHui Meng
 * @Date: 2021-04-13 20:02:56
 */
/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        // root本身就是一层，所以初始化step为1
        int step = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            //将当前队列中所有的节点向四周扩散
            for(int i = 0; i<size; i++){
                TreeNode cur = queue.poll();
                //判断是否到达终点
                if(cur.left == null && cur.right == null){
                    return step;
                }
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            //增加步数
            step++;
        }
        return step;
    }
}
// @lc code=end

