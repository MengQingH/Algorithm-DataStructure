/*
 * @Author: QingHui Meng
 * @Date: 2021-03-19 16:14:53
 */
/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
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

    //使用HashMap来存放所有的子树以及存储的次数
    private HashMap<String, Integer> trees = new HashMap<>();
    private LinkedList<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    /**
     * 方法定义：构造以root为根节点的树的序列
     * 
     * @param {TreeNode} root
     * @return {*}
     */
    private String traverse(TreeNode root){
        //base case
        if(root == null)
            return "#";
        
        String left = traverse(root.left);
        String right = traverse(root.right);

        //可以使用三种遍历方式构造
        String subTree = root.val + "," + left + "," + right;

        //获取
        int time = trees.getOrDefault(subTree, 0);
        if(time == 1){
            res.add(root);
        }
        trees.put(subTree, time+1);
        return subTree;
    }
}
// @lc code=end

