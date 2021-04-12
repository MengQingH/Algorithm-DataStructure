/*
 * @Author: QingHui Meng
 * @Date: 2021-04-12 14:40:31
 */
/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {

    //////////////////////////优化解法//////////////////////////////
    
    /**
     * 思路：遍历数组，每遇到一个数，就在当前所有子集上加上这个数形成新的子集。
     * 
     * @param {int[]} nums
     * @return {*}
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        //遍历数组
        for(int i = 0; i<nums.length; i++){
            int size = res.size();
            //遍历所有子集
            for(int j = 0; j<size; j++){
                //新的子集需要重新初始化
                List<Integer> track = new ArrayList<>(res.get(j));
                track.add(nums[i]);
                res.add(track);
            }
        }
        return res;
    }




    //////////////////////////递归解法//////////////////////////////
    private List<List<Integer>> res = new ArrayList<>();


    public List<List<Integer>> subsets1(int[] nums) {
        List<Integer> track = new ArrayList<>();

        backtrack(nums, track, 0);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> track, int first){
        //添加到结果中
        res.add(new ArrayList<>(track));

        for(int i = first; i<nums.length; i++){
            //做选择
            track.add(nums[i]);
            //回溯
            backtrack(nums, track, i+1);
            //撤销选择
            track.remove(track.size()-1);
        }
    }
}
// @lc code=end

