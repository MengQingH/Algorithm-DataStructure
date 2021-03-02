package BST;

import node.TreeNode;

public class Lc0450__删除二叉搜索树中的节点_2 {

    /**
     * 找到要结点以后，该如何删除这个节点，分几种情况：
     * 1. 如果A恰好是末端结点，两个子结点都为空，那么可以直接删掉。
     * 2. 如果A只有一个非空结点，那么要让这个孩子顶替A的位置。
     * 3. 如果A有两个子结点，那么要让左子树中最大的那个结点或者右子树中最小的结点来顶替自己的位置。
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key){
        if (root == null)
            return null;
        if (root.val == key){
            //处理情况1和情况2
            if (root.left == null)return root.right;
            if (root.right == null)return root.left;
            //处理情况3，这里用的是使用右子树中的最小节点
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }else if (root.val < key){
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    /**
     * 获取以node为根节点的二叉搜索树的最小值
     * @param node
     * @return
     */
    private TreeNode getMin(TreeNode node){
        if (node == null)
            return null;
        while (node.left != null)
            node = node.left;
        return node;
    }

}
