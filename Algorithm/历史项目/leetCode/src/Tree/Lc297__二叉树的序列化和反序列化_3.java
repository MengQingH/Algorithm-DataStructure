package Tree;

import node.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class Lc297__二叉树的序列化和反序列化_3 {

    //分隔符
    String SEP = ",";
    //空指针
    String NULL = "#";

    /**********************************前序遍历序列化***************************/

    /**
     * 使用前序遍历的方式序列化二叉树
     * @param root
     * @return
     */
    public String serializePre(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serializePre(root, sb);
        return sb.toString();
    }
    private void serializePre(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append(NULL).append(SEP);
            return;
        }

        /****** 前序遍历位置 ******/
        sb.append(root.val).append(SEP);

        serializePre(root.left, sb);
        serializePre(root.right, sb);
    }

    /**
     * 使用前序遍历的方式反序列化二叉树
     * @param data
     * @return
     */
    public TreeNode deserializePre(String data){
        //把节点值从字符串中取出来并放入链表
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(SEP)));
        return deserializePre(nodes);
    }
    private TreeNode deserializePre(LinkedList<String> nodes){
        if (nodes.isEmpty())
            return null;

        /****** 前序遍历位置 ******/
        //列表最左侧的结点是根节点
        String val = nodes.removeFirst();
        if (val.equals(NULL)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = deserializePre(nodes);
        node.right = deserializePre(nodes);

        return node;
    }


    /**********************************后序遍历序列化***************************/

    /**
     * 后序遍历序列化
     * @param root
     * @return
     */
    public String serializePost(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serializePost(root, sb);
        return sb.toString();
    }
    private void serializePost(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append(NULL).append(SEP);
            return;
        }

        serializePost(root.left, sb);
        serializePost(root.right, sb);

        /****** 后序遍历位置 ******/
        sb.append(root.val).append(SEP);
    }

    /**
     * 后序遍历反序列化
     * @param data
     * @return
     */
    public TreeNode deserializePost(String data){
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(SEP)));
        return deserializePost(nodes);
    }
    private TreeNode deserializePost(LinkedList<String> nodes){
        if (nodes.isEmpty())
            return null;
        //从最后的值开始遍历
        String val = nodes.removeLast();
        if (val.equals(NULL))
            return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        //根据后序遍历的特点，先构造右子树，再构造左子树
        node.right = deserializePost(nodes);
        node.left = deserializePost(nodes);

        return node;
    }

    /**********************************中序遍历序列化***************************/
    //中序遍历无法实现二叉树的序列化和反序列化，因为中序遍历反序列化时无法确认根节点。
}
