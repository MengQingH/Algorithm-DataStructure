package dataStructure.binaryTree;

/**
 * 二叉树的结点
 */
public class Node {

    private Object data;//结点值
    private Node leftChild;//左子树的引用
    private Node RightChild;//右子树的引用

    public Node(Object data, Node leftChild, Node rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        RightChild = rightChild;
    }

    public Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return RightChild;
    }

    public void setRightChild(Node rightChild) {
        RightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", RightChild=" + RightChild +
                '}';
    }
}
