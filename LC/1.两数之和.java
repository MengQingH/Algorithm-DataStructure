/*
 * @Author: QingHui Meng
 * @Date: 2021-03-19 16:40:35
 */
/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {

    /**
     * 使用哈希查找的时间复杂度为O(1)，所以可以使用哈希容器来降低时间复杂度。
     * 
     * @param {int[]} nums
     * @param {int} target
     * @return {*}
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                res[0] = i;
                res[1] = map.get(target-nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
// @lc code=end

