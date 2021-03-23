package dataStructure.binaryTree;

/**
 * 二叉树的接口
 */
public interface BinaryTree {
    /**
     * 是否空树
     * @return
     */
    boolean isEmpty();

    /**
     * 树结点数量
     * @return
     */
    int size();

    /**
     * 获取二叉树的高度
     * @return
     */
    int getHeight();

    /**
     * 查询指定值的结点
     * @param value
     * @return
     */
    Node findkey(int value);

    /**
     * 前序遍历递归操作
     */
    void preOrderTraverse();

    /**
     * 中序遍历递归操作
     */
    void inOrderTraverse();

    /**
     * 后序遍历递归操作
     */
    void postOrderTraverse();


    /**
     * 中序遍历非递归操作
     * 1. 对于任意结点current，若该结点不为空则将该节点压栈，并将左子树结点置为current，重复此操作，直到
     */
    void inOrderByStack();

    /**
     * 前序遍历非递归操作
     */
    void preOrderByStack();

    /**
     * 按照层次遍历二叉树
     */
    void levelOrderByQueue();

}
