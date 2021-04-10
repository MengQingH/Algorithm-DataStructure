/*
 * @Author: QingHui Meng
 * @Date: 2021-04-10 15:19:38
 */
/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {

    /**
     * 使用前后指针解决
     * 
     * @param {int[]} nums
     * @param {int} val
     * @return {*}
     */
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while(fast < nums.length){
            //当快指针不等于val时，赋值给慢指针
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        //由于慢指针先赋值再++，所以不包含val的元素是0-slow-1
        return slow;
    }
}
// @lc code=end

