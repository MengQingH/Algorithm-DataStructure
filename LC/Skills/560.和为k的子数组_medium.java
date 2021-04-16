/*
 * @Author: QingHui Meng
 * @Date: 2021-04-16 13:43:36
 */
/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为K的子数组
 */

// @lc code=start
class Solution {

    /**
     * 优化方案，使用哈希表记录有几个sum[j]和sum[i]-k相等，直接更新结果，避免了内层的循环
     * 
     * @param {int[]} nums
     * @param {int} k
     * @return {*}
     */
    public int subarraySum(int[] nums, int k){
        HashMap<Integer, Integer> preSum = new HashMap<>();
        // 需要把0加入到前缀和中
        preSum.put(0, 1);

        int res = 0;
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            // 0..i的和
            sum += nums[i];
            if(preSum.containsKey(sum-k))
                res += preSum.get(sum-k);
            preSum.put(sum, preSum.getOrDefault(sum, 0)+1);
        }
        return res;
    }

    /**
     * 可以使用前缀和数组
     * 
     * @param {int[]} nums
     * @param {int} k
     * @return {*}
     */
    public int subarraySum1(int[] nums, int k) {
        // 初始化前缀和数组
        int[] preSum = new int[nums.length+1];
        for(int i = 0; i<nums.length; i++){
            preSum[i+1] = preSum[i] + nums[i];
        }

        int res = 0;
        //穷举所有的子数组
        for(int i = 1; i<preSum.length; i++){
            for(int j = 0; j<i; j++){
                // j...i-1的和
                if(preSum[i] - preSum[j] == k)
                    res++;
            }
        }
        return res;
    }
}
// @lc code=end

