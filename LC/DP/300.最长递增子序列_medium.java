/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {

    /**
     * 通过数学归纳法的思想得出解法思路：假设dp数组的[0...n-1]都已经被算出来了，
     * 那么怎么求出dp[n]呢。
     * 
     * dp数组的定义：dp[i]表示以nums[i]结尾的最长子序列的长度。那么最长递增子序列就是dp的最大值
     * arr: 1--4--3--4--2--3 
     * dp : 1--2--2--3--2--?
     * 由dp[1...4]来求dp[5]，既然nums[5]=3，
     * 那么nums[1...4]中小于3的元素的子序列的长度+1就是dp[5]所有可能的值，这些值中的最大值即为所求
     * 
     * @param {int[]} nums
     * @return {*}
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // nums中元素的最小值是1，因为要包含自己
        Arrays.fill(dp, 1);
        for(int i = 1; i<nums.length; i++){
            for(int j = 0; j<i; j++){
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int res = 1;
        for(int i = 0; i<dp.length; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
// @lc code=end

