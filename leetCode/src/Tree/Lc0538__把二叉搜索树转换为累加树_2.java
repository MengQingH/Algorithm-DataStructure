package Tree;

import node.TreeNode;

public class Lc0538__把二叉搜索树转换为累加树_2 {

    public TreeNode convertBST(TreeNode root){
        traverse(root);
        return root;
    }

    private int sum = 0;

    /**
     * 利用BST中序遍历有序的特性，降序遍历整棵树，并设置累加值
     * @param root
     */
    private void traverse(TreeNode root){
        //base case
        if (root == null)
            return;

        traverse(root.right);

        //维护累加值并将BST转换为累加树
        sum += root.val;
        root.val = sum;

        traverse(root.left);
    }

}
