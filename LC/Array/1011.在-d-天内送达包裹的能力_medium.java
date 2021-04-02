/*
 * @Author: QingHui Meng
 * @Date: 2021-04-01 16:38:52
 */
/*
 * @lc app=leetcode.cn id=1011 lang=java
 *
 * [1011] 在 D 天内送达包裹的能力
 */

// @lc code=start
class Solution {

    /**
     * 重点是如何确定载重的最大值和最小值：由于包裹不能拆分，所以载重的最小值应该是max(weights)
     *  最大值应该是sum(weights)。
     * 由于确定的是最低运载能力，所以使用寻找左侧边界的二分查找
     * 
     * @param {int[]} weights
     * @param {int} D
     * @return {*}
     */
    public int shipWithinDays(int[] weights, int D) {
        //确定左右边界
        int left = getMax(weights);
        int right = getSum(weights)+1;
        int mid;
        while(left < right){
            mid = left + (right - left)/2;
            if(canFinish(weights, D, mid)){
                right = mid;
            } else{
                left = mid+1;
            }
        }
        return left;

    }

    /**
     * 运载重量为weight的情况下，d天内能不能运载完arr
     * 
     * @param {int[]} arr
     * @param {int} d
     * @param {int} weight
     * @return {*}
     */
    private boolean canFinish(int[] arr, int d, int weight){
        int takeD = 1;//花费时间最开始应该是1，不是0
        int sum = 0;
        for(int i : arr){
            if(sum+i > weight){
                takeD++;
                sum = 0;
            }
            sum += i;
        }
        return takeD <= d;
    }

    private int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i : arr){
            max = Math.max(i, max);
        }
        return max;
    }

    private int getSum(int[] arr){
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        return sum;
    }


}
// @lc code=end

