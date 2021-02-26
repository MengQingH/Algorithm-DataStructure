package Tree;

import node.TreeNode;

public class Lc0105__从前序与中序遍历序列构造二叉树_2 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    /**
     * 方法定义：对范围内的前序和中序遍历序列构造根节点并返回
     * @param preOrder
     * @param preStart
     * @param preEnd
     * @param inOrder
     * @param inStart
     * @param inEnd
     * @return
     */
    private TreeNode build(int[] preOrder, int preStart, int preEnd,
                           int[] inOrder, int inStart, int inEnd) {
        //base case
        if (preStart > preEnd) {
            return null;
        }

        //前序遍历的第一个值就是根节点
        int rootValue = preOrder[preStart];

        //找出根节点在中序遍历序列中的索引，方便确定递归的范围
        int index = 0;//索引默认值要设置为0
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == rootValue) {
                index = i;
                break;
            }
        }

        //求出左子树的长度，方便确定递归的范围
        //（左子树的起点+左子树的长度  该位置处的结点应该是左子树后的第一个结点；左子树的起点+左子树长度-1  才是左子树的最后一个结点）
        int leftSize = index - inStart;

        //构造根节点，并递归构造左子树和右子树
        TreeNode root = new TreeNode(rootValue);
        root.left = build(preOrder, preStart + 1, preStart + leftSize, inOrder, inStart, index - 1);
        root.right = build(preOrder, preStart + leftSize + 1, preEnd, inOrder, index + 1, inEnd);

        return root;
    }

}
