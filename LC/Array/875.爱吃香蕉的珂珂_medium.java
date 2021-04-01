/*
 * @Author: QingHui Meng
 * @Date: 2021-04-01 13:37:18
 */
/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start
class Solution {

    /**
     * 暴力算法思路：k最小为1，最大为max(piles)，可以穷举这些值，直到找到最小的k
     * 二分算法思路：由暴力思路可知，需要穷举0-max(piles)有序序列，所以可以二分查找的思路，
     *      由于题目中要找最小速度，所以使用寻找左侧边界的二分查找
     * 
     * @param {int[]} piles
     * @param {int} h
     * @return {*}
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles)+1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(canFinish(piles, mid, h)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    /**
     * 判断当前speed是否满足条件
     * 
     * @param {int[]} piles
     * @param {int} speed
     * @param {int} h
     * @return {*}
     */
    private boolean canFinish(int[] piles, int speed, int h){
        int time = 0;
        for(int n : piles){
            //每一堆的耗时
            time += (n / speed) + ((n % speed > 0) ? 1 : 0);
        }
        return time <= h;
    }

    private int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i: arr){
            max = Math.max(i, max);
        }
        return max;
    }
}
// @lc code=end

