package Tree;

public class Lc0116__填充每个节点的下一个右侧节点指针_2 {

    Node connect(Node root){
        if(root == null) return null;
        connectTwoNode(root.left, root.right);
        return root;
    }

    /**
     * 方法定义：将传入的两个结点相连接
     * @param node1
     * @param node2
     */
    void connectTwoNode(Node node1, Node node2){
        //base case
        if(node1 == null || node2 == null){
            return;
        }

        /**** 前序遍历位置 ****/
        //将传入的两个结点连接
        node1.next = node2;

        //连接相同父结点的两个子结点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        //连接跨越父结点的两个子结点
        connectTwoNode(node1.right, node2.left);
    }


    /**
     * 二叉树的结点定义
     */
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

}
