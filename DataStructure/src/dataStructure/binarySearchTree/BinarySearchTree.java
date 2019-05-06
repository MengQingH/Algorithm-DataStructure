package dataStructure.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树
 * 此类中的二叉搜索树存储的结点为键值对，插入时比较键的大小
 * 与普通二叉树的区别：
 * 1. 普通二叉树的元素之间没有规律，所以必须创建结点时把左右结点说明清楚，最后把根结点传入二叉树
 * 2. 二分查找树对于如何排列元素有规则，所以根节点可以为空，然后通关不断添加元素的方式来创建二叉树
 */
public class BinarySearchTree {

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二叉树中添加一个元素（递归）
     *
     * @param node
     */
    public void add(Node node) {
        root = add(root, node);

    }

    /**
     * 向根为r的二叉树中添加一个元素node，返回插入新节点后的二叉搜索树的跟
     *
     * @param r
     * @param node
     * @return
     */
    private Node add(Node r, Node node) {

        //2. 处理递归到底的情况
        if (r == null) {
            size++;
            return node;
        }

        //1. 先进行递归的操作
        //如果根节点等于插入的结点值就更新
        if (r.getKey() == node.getKey()) {
            r.setValue(node.getValue());
        }
        //如果根节点的值小于插入结点的值，就把这个结点插入到根节点的右子树中，并返回右子树的根
        if (r.getKey() < node.getKey()) {
            r.setRight(add(r.getRight(), node));
        }
        //如果根节点的值大于插入结点的值，就把这个结点插入到根节点的左子树中，并返回左子树的根
        if (r.getKey() > node.getKey()) {
            r.setLeft(add(r.getLeft(), node));
        }

        return r;
    }

    /**
     * 查看二叉树中是否含有该键值
     *
     * @param key
     * @return
     */
    public boolean contain(int key) {
        return contain(root, key);
    }

    /**
     * 查看以r为根的二叉树中是否含有key这个键值
     *
     * @param r
     * @param key
     * @return
     */
    private boolean contain(Node r, int key) {
        //2. 判断递归到底的情况
        if (r == null) {
            return false;
        }

        //1. 处理递归操作
        if (key == r.getKey()) {
            return true;
        } else if (r.getKey() > key) {
            return contain(r.getLeft(), key);
        } else return contain(r.getRight(), key);
    }

    /**
     * 通过key在二叉树中查找相应的value
     *
     * @param key
     * @return
     */
    public String search(int key) {
        return search(root, key);
    }

    /**
     * 查找以r为根节点的二叉树中是否有key
     *
     * @param r
     * @param key
     * @return
     */
    private String search(Node r, int key) {
        if (r == null)
            return null;

        if (r.getKey() == key) {
            return r.getValue();
        } else if (r.getKey() < key) {
            return search(r.getRight(), key);
        } else
            return search(r.getLeft(), key);
    }

    /**
     * 对二叉树进行前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 对根节点为r的二叉树进行前序遍历
     *
     * @param r
     */
    private void preOrder(Node r) {
        if (r != null) {
            System.out.print(r.getValue() + "  ");
            preOrder(r.getLeft());
            preOrder(r.getRight());
        }
    }

    /**
     * 对二叉树进行中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 对以r为根的二叉树进行中序遍历
     *
     * @param r
     */
    private void inOrder(Node r) {
        if (r != null) {
            inOrder(r.getLeft());
            System.out.println(r.getValue());
            inOrder(r.getRight());
        }
    }

    /**
     * 对二叉树进行后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 对根为r的二叉树进行后序遍历
     *
     * @param r
     */
    private void postOrder(Node r) {
        if (r != null) {
            postOrder(r.getLeft());
            postOrder(r.getRight());
            System.out.println(r.getValue());
        }
    }

    /**
     * 使用队列来进行二叉树的层次遍历
     */
    public void levelOrder() {
        Queue queue = new LinkedList();
        queue.add(root);
        while (queue.size() != 0) {
            Node r = (Node) queue.poll();
            System.out.println(r.getValue());
            if (r.getLeft() != null)
                queue.offer(r.getLeft());
            if (r.getRight() != null)
                queue.offer(r.getRight());
        }
    }

    /**
     * 返回二叉树中的最小值索引
     *
     * @return
     */
    public int minNum() {
        return minNum(root).getKey();
    }

    /**
     * 返回以r为根节点的二叉树的最小值
     * 二叉树最左边的结点为最小值结点
     *
     * @param r
     * @return
     */
    private Node minNum(Node r) {
        //如果这个结点没有左子树那么为最小值结点并返回
        if (r.getLeft() == null) {
            return r;
        } else //如果这个结点有左子树那么对左子树进行递归
            return minNum(r.getLeft());
    }

    /**
     * 返回二叉树的最大值索引
     *
     * @return
     */
    public int maxNum() {
        return maxNum(root).getKey();
    }

    /**
     * 返回以r为根节点的二叉树的最大值
     * 最右边的结点为最大值结点
     *
     * @param r
     * @return
     */
    private Node maxNum(Node r) {
        //如果这个结点没有右子树那么为最大值结点
        if (r.getRight() == null) {
            return r;
        } else //如果结点有右子树则对右子树进行递归
            return maxNum(r.getRight());
    }


    /**
     * 删除二叉树中的最小值
     */
    public void removeMin() {
        if (root != null) {
            root = removeMin(root);
        }
    }

    /**
     * 删除二叉树中的最小值，并把最小值结点的右子树顶替最小值结点原来的位置
     *
     * @param r
     * @return 返回值为左子树的根节点。并且在递归方法中设置左子树引用指向下一层返回的结点
     */
    private Node removeMin(Node r) {
        //如果这个结点没有左子树那么这个结点就是最小值结点
        if (r.getLeft() == null) {
            //删除一个最小值结点后就把这个结点的右子树顶替这个结点
            Node rightNode = r.getRight();
            size--;
            //返回右子树的根节点，最小值结点的上一层结点会把这个右子树的根节点设置成自己的左子树结点
            return rightNode;
        }
        //如果这个结点有左子树对左子树进行递归，并把递归返回的结点设置为左子树
        r.setLeft(removeMin(r.getLeft()));
        return r;
    }

    /**
     * 删除二叉树中的最大值
     */
    public void removeMax() {
        if (root != null) {
            root = removeMax(root);
        }
    }

    /**
     * 删除以r为结点的二叉树的最大值
     *
     * @param r
     * @return
     */
    private Node removeMax(Node r) {
        //如果该节点的右子树为空那么该节点为最大值结点
        if (r.getRight() == null) {
            //返回该节点的左子树根节点
            Node leftNode = r.getLeft();
            size--;
            return leftNode;
        }
        //如果右子树不为空那么对右子树进行递归并设置递归返回值为右子树
        r.setRight(removeMax(r.getRight()));
        //返回当前结点
        return r;
    }

}
