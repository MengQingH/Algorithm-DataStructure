/*
 * @Author: QingHui Meng
 * @Date: 2021-04-10 17:47:15
 */
/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> output = new ArrayList<>();
        for(int num : nums){
            output.add(num);
        }
        backtrack(nums, output, 0);
        return res;
    }

    /**
     * 递归方法
     * 
     * @param {int[]} nums
     * @param {LinkedList<Integer>} track 记录路径
     * @return {*}
     */
    private void backtrack(int[] nums, List<Integer> output, int first){
        // 如果所有的数填完了，满足条件，添加到结果中
        if(first == nums.length){
            //添加结果时需要重新new一个列表
            res.add(new ArrayList<Integer>(output));
        }

        //第0-first数是已经填过的数
        for(int i = first; i<nums.length; i++){
            //对数组进行遍历，把元素提到first的位置，表示已经填过
            Collections.swap(output, first, i);
            backtrack(nums, output, first+1);
            //撤回交换
            Collections.swap(output, i, first);
        }
    }
}
// @lc code=end

