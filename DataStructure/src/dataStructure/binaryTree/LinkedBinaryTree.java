package dataStructure.binaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**`
 * 链式二叉树
 */
public class LinkedBinaryTree implements BinaryTree {

    private Node root;//根节点

    public LinkedBinaryTree() {
    }

    public LinkedBinaryTree(Node root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        System.out.print("结点的个数：");
        return this.size(root);
    }

    private int size(Node root) {
        if (root != null) {
            int left = this.size(root.getLeftChild());
            int right = this.size(root.getRightChild());
            return left + right + 1;
        } else return 0;
    }

    @Override
    public int getHeight() {
        System.out.print("二叉树的高度：");
        return this.getHeight(root);
    }

    private int getHeight(Node root) {
        if (root != null) {
            //获取左子树的高度
            int left = this.getHeight(root.getLeftChild());
            //获取右子树的高度
            int right = this.getHeight(root.getRightChild());
            //返回左子树、右子树之间较大的高度并+1
            return left > right ? left + 1 : right + 1;
        } else return 0;
    }

    @Override
    public Node findkey(int value) {
        System.out.print("找到的结点为：");
        return this.findkey(value, root);
    }

    private Node findkey(Object value, Node root) {
        if (root == null) {//如果树为空
            return null;
        } else if (root != null && root.getData() == value) {//如果要找的值和根节点的值相同

            return root;
        } else {//如果值和左子树或右子树的值相同
            Node node1 = this.findkey(value, root.getLeftChild());
            Node node2 = this.findkey(value, root.getRightChild());
            if (node1 != null && node1.getData() == value) {
                return node1;
            } else if (node2 != null && node2.getData() == value) {
                return node2;
            } else return null;
        }
    }

    @Override
    public void preOrderTraverse() {
        if (root != null) {
            //输出根节点的值
            System.out.print(root.getData() + "  ");
            //对左子树进行先序遍
            //创建左子树
            BinaryTree leftTree = new LinkedBinaryTree(root.getLeftChild());
            leftTree.preOrderTraverse();
            //对右子树进行先序遍历
            //创建右子树
            BinaryTree rightTree = new LinkedBinaryTree(root.getRightChild());
            rightTree.preOrderTraverse();
        }
    }

    @Override
    public void inOrderTraverse() {
        System.out.print("中序遍历：");
        this.inOrderTraverse(root);
        System.out.println();
    }

    private void inOrderTraverse(Node root) {
        if (root != null) {
            //遍历左子树
            this.inOrderTraverse(root.getLeftChild());
            //遍历根节点
            System.out.print(root.getData() + "  ");
            //遍历右子树
            this.inOrderTraverse(root.getRightChild());
        }
    }

    @Override
    public void postOrderTraverse() {
        System.out.print("后序遍历：");
        this.postOrderTraverse(root);
        System.out.println();
    }

    private void postOrderTraverse(Node root) {
        if (root != null) {
            //遍历左子树
            this.postOrderTraverse(root.getLeftChild());
            //遍历右子树
            this.postOrderTraverse(root.getRightChild());
            //遍历根节点
            System.out.print(root.getData() + "  ");
        }
    }

    @Override
    public void inOrderByStack() {
        System.out.print("中序非递归遍历：");
        Deque<Node> stack = new LinkedList<Node>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeftChild();
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                System.out.print(current.getData() + "  ");
                current = current.getRightChild();
            }
        }
        System.out.println();
    }

    @Override
    public void preOrderByStack() {

    }

    @Override
    public void levelOrderByQueue() {
        System.out.print("层次遍历：");
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (queue.size() != 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node temp = queue.poll();
                System.out.print(temp.getData() + "  ");
                if (temp.getLeftChild() != null) queue.add(temp.getLeftChild());
                if (temp.getRightChild() != null) queue.add(temp.getRightChild());
            }
        }
        System.out.println();
    }
}
