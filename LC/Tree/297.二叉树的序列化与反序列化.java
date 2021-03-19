/*
 * @Author: QingHui Meng
 * @Date: 2021-03-19 11:22:35
 */
/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    //分隔符
    String SEP = ",";
    //空指针
    String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializePost(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //把结点值从字符串中取出并放入链表
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(SEP)));
        return deserializePost(nodes);
    }

    /******************************* 前序遍历序列化 *******************************/
    /**
     * 使用前序遍历方式序列化二叉树
     * 方法定义：序列化root结点，添加到sb中
     * 
     * @param {TreeNode} root
     * @param {StringBuilder} sb
     * @return {*}
     */
    private void serializePre(TreeNode root, StringBuilder sb){
        //base case
        if(root == null){
            sb.append(NULL).append(SEP);
            return;
        }
        
        /******** 前序遍历位置 ********/
        sb.append(root.val).append(SEP);

        serializePre(root.left, sb);
        serializePre(root.right, sb);
    }

    /**
     * 使用前序遍历方式反序列化二叉树
     * 方法定义：对前序遍历序列nodes，生成一个根节点并把值从序列中移除
     * 
     * @param {LinkedList<String>} nodes
     * @return {*}
     */
    private TreeNode deserializePre(LinkedList<String> nodes){
        //base case
        if(nodes.isEmpty())
            return null;
        
        /******* 前序遍历位置 *******/
        //列表最左侧的是根节点
        String value = nodes.removeFirst();
        if(value.equals(NULL))
            return null;

        //构造根节点并递归构造左右子树
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = deserializePre(nodes);
        root.right = deserializePre(nodes);
        return root;
    }

    /******************************* 后序遍历序列化 *******************************/
    /**
     * 使用后序遍历的方式进行序列化
     * 
     * @param {TreeNode} root
     * @param {StringBuilder} sb
     * @return {*}
     */
    private void serializePost(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(NULL).append(SEP);
            return;
        }
            
        serializePost(root.left, sb);
        serializePost(root.right, sb);

        /******** 后序遍历位置 ********/
        sb.append(root.val).append(SEP);
    }

    /**
     * 使用后序遍历的方式进行反序列化
     * 
     * @param {LinkedList<String>} values
     * @return {*}
     */
    private TreeNode deserializePost(LinkedList<String> nodes){
        //base case
        if(nodes.isEmpty())
            return null;
        
        //最后的结点值为根节点
        String value = nodes.removeLast();
        if(value.equals(NULL))
            return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(value));
        //根据后序遍历的特点，应该先构造右子树，再构造左子树
        root.right = deserializePost(nodes);
        root.left = deserializePost(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

