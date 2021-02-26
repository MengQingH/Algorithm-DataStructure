package BST;

import node.TreeNode;

public class Lc0230__二叉搜索树中第K小的元素_2 {

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    //计算排位和结果
    private int rank = 0;
    private int res = 0;

    /**
     * 方法定义：遍历结点整棵BST，找到root的排位
     * 由于该问题只需要找出排位为k的元素，所以不需要其他元素的信息
     *
     * @param root
     * @param k
     */
    private void traverse(TreeNode root, int k) {
        //base case
        if (root == null) {
            return;
        }

        traverse(root.left, k);

        /** 中序遍历代码位置 **/
        rank++;//由于rank的默认值设置的是0，所以需要先++再比较
        if (rank == k){
            res = root.val;
            return;//虽然显式的return了，但是只是return的当前方法，递归的上一层还要继续执行。
        }

        traverse(root.right, k);

    }

}
