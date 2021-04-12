/*
 * @Author: QingHui Meng
 * @Date: 2021-04-12 15:37:00
 */
/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> track = new ArrayList<>();

        backtrack(n, track, 1, k);
        return res;
    }

    /**
     * 回溯方法和计算子集类似，都是不能包含重复元素。
     * 
     * @param {*}
     * @return {*}
     */
    private void backtrack(int n, List<Integer> track, int first, int k){
        //满足条件，添加到结果中
        if(track.size() == k){
            res.add(new ArrayList<>(track));
            return;
        }

        //对first之后的元素进行选择
        for(int i = first; i<=n; i++){
            //做选择
            track.add(i);
            //递归
            backtrack(n, track, i+1, k);
            //撤回选择
            track.remove(track.size()-1);
        }
    }
}
// @lc code=end

