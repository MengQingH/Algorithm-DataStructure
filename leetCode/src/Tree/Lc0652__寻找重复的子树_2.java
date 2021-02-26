package Tree;

import node.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Lc0652__寻找重复的子树_2 {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    //使用一个HashMap来存放所有的子树以及存储的次数
    private HashMap<String, Integer> trees = new HashMap<>();
    private LinkedList<TreeNode> res = new LinkedList<>();

    /**
     * 方法定义：构造以root为根节点的子树的序列，并判断是否是重复子树
     *
     * @param root
     * @return
     */
    private String traverse(TreeNode root) {
        //base case
        if (root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        // 可以使用前序、中序或后序遍历方式
        String subTree = left + "," + right + "," + root.val;

        //获取出现这个序列出现的次数
        int time = trees.getOrDefault(subTree, 0);
        //只有time == 1 时才添加，就算有多个重复的序列，也只添加一次
        if (time == 1){
            res.add(root);
        }
        trees.put(subTree, time + 1);
        return subTree;
    }
}
