/*
 * @Author: Jason Meng
 * @Date: 2021-03-18 15:20:52
 */
/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    /**
     * 问题难点在于如何连接一个结点左子树的右节点和左子树的左节点，可以通过增加函数的参数解决。
     * 
     * @param {Node} root
     * @return {*}
     */
    public Node connect(Node root) {
        if(root == null)return null;
        connectTwoNodes(root.left, root.right);
        return root;
    }

    /**
     * 方法定义：将传入的两个结点相连接
     * 
     * @param {Node} node1
     * @param {Node} node2
     * @return {*}
     */
    private void connectTwoNodes(Node node1, Node node2){
        //base case
        if(node1 == null || node2 == null) return;

        /* 前序遍历位置 */
        //将传入的两个结点相连接
        node1.next = node2;

        //连接相同父结点的两个子结点
        connectTwoNodes(node1.left, node1.right);
        connectTwoNodes(node2.left, node2.right);
        //连接跨越父结点的两个子结点
        connectTwoNodes(node1.right, node2.left);
        
    }
}
// @lc code=end

