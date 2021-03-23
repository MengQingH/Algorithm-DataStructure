package Tree;

import node.TreeNode;

public class Lc0106__从中序与后序遍历序列构造二叉树_2 {

    public TreeNode buildTree(int[] inorder, int[] postorder){
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    /**
     * 方法定义：对范围内的中序和后序序列，找出根节点并返回
     * @param inOrder
     * @param inStart
     * @param inEnd
     * @param postOrder
     * @param postStart
     * @param postEnd
     * @return
     */
    private TreeNode build(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd){
        //base case
        if (postStart > postEnd)
            return null;

        //根据后序遍历的定义，根节点的值应该是
        int rootValue = postOrder[postEnd];

        //找出根节点在中序遍历中的索引
        int index = 0;//注意index要从0开始
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == rootValue){
                index = i;
                break;
            }
        }

        //求出左子树的长度
        //（左子树的起点+左子树的长度  该位置处的结点应该是左子树后的第一个结点；左子树的起点+左子树长度-1  才是左子树的最后一个结点）
        int leftSize = index - inStart;

        //创建根节点并递归调用左右子树
        TreeNode root = new TreeNode(rootValue);
        root.left = build(inOrder, inStart, index - 1, postOrder, postStart, postStart + leftSize - 1);
        root.right = build(inOrder, index +1, inEnd, postOrder, postStart + leftSize, postEnd - 1);
        return root;
    }

}
