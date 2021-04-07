/*
 * @Author: QingHui Meng
 * @Date: 2021-04-06 14:05:25
 */
/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {

    /**
     * 解法类似二分查找，调节left和right来调整num的大小
     * 
     * @param {int[]} numbers
     * @param {int} target
     * @return {*}
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        //注意条件，循环终止条件是left == right，此时满足条件也不符合题目要求
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left+1, right+1};
            }else if(sum > target){
                right--;
            }else if(sum < target){
                left++;
            }
        }
        return new int[]{-1,-1};
    }
}
// @lc code=end

