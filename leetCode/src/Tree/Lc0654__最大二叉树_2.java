package Tree;

import node.TreeNode;

public class Lc0654__最大二叉树_2 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }

    /**
     * 方法定义：对当前范围内的nums构造一个最大根节点
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public TreeNode construct(int[] nums, int left, int right){
        //base case
        if(left > right){
            return null;
        }

        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = left;i <= right; i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }

        //根据最大值构造根节点
        TreeNode root = new TreeNode(max);
        //构造根结点的左右子节点
        root.left = construct(nums, left, index-1);
        root.right = construct(nums, index+1, right);
        return root;
    }

}
