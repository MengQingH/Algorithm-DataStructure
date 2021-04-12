/*
 * @Author: QingHui Meng
 * @Date: 2021-04-10 15:35:37
 */
/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {

    /**
     * 使用快慢指针来解决
     * 
     * @param {int[]} nums
     * @return {*}
     */
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while(fast < nums.length){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while(slow < nums.length){
            nums[slow] = 0;
            slow++;
        }
    }
}
// @lc code=end

