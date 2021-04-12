/*
 * @Author: QingHui Meng
 * @Date: 2021-04-09 15:12:09
 */
/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {

    /**
     * 思路：使用快慢指针。快指针每遇到一次不重复的元素slow就向前前进一步。
     *  这样当fast指针遍历完整个数组之后，0-slow就是非重复元素，其余的元素都是重复元素。
     * 
     * @param {int[]} nums
     * @return {*}
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 1;
        while(fast < nums.length){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}
// @lc code=end

