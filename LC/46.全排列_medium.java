/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {

    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     * 
     * 
     * @param {int[]} nums
     * @param {LinkedList<Integer>} track 记录路径
     * @return {*}
     */
    private void backtrack(int[] nums, LinkedList<Integer> track){

    }
}
// @lc code=end

