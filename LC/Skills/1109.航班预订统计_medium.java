/*
 * @Author: QingHui Meng
 * @Date: 2021-04-16 15:40:53
 */
/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start
class Solution {

    /**
     * 使用差分数组
     * 
     * @param {int[][]} bookings
     * @param {int} n
     * @return {*}
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 构造差分数组，这道题初始值都是0
        int[] diff = new int[n];

        // 操作差分数组
        for(int[] booking : bookings){
            // 注意构造数组索引时要-1
            increment(diff, booking[0]-1, booking[1]-1, booking[2]);
        }

        // 构造返回结果
        int[] res = new int[n];
        res[0] = diff[0];
        for(int i = 1; i<n; i++){
            res[i] = res[i-1] + diff[i];
        }
        return res;
    }
    
    /**
     * 增加区间值
     * 
     * @param {int[]} diff
     * @param {int} i
     * @param {int} j
     * @param {int} val
     * @return {*}
     */
    private void increment(int[] diff, int i, int j, int val){
        diff[i] += val;
        if(j+1 < diff.length){
            diff[j+1] -= val;
        }
        return diff;
    }
}
// @lc code=end

