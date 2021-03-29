/*
 * @Author: QingHui Meng
 * @Date: 2021-03-29 16:09:00
 */
/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {

    /**
     * 思路2：使用单调队列
     * 对于一个数i:（前提是下面提到的这些值都是在窗口内）
     * 如果i之前的数都小于i并且都在窗口内，那么窗口滑动的过程中，i前面的这些值的最大值就是i
     * 如果i之后的元素j大于i并且都在窗口内，那么窗口的滑动的过程中，最大值不可能是i
     * 
     * 所以可以设计一个单调队列
     * 
     * @param {int[]} nums
     * @param {int} k
     * @return {*}
     */
    public int[] maxSlidingWindow_(int[] nums, int k) {
        
    }

    /**
     * 思路1：借助堆来解决 时间复杂度O(nlogn)
     * PS 时间复杂度太高，超时
     * 
     * @param {int[]} nums
     * @param {int} k
     * @return {*}
     */
    public int[] maxSlidingWindow_(int[] nums, int k) {
        //结果集的长度为nums.length-k+1
        int[] res = new int[nums.length-k+1];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b-a);

        //先在堆中添加k-1个元素
        for(int i = 0; i<k-1; i++){
            queue.add(nums[i]);
        }
        //从第k个元素，索引为k-1的位置开始
        for(int i = k-1; i<nums.length; i++){
            //当前堆中索引最小的元素
            int index = i-k+1;
            queue.offer(nums[i]);
            res[index] = queue.peek();
            queue.remove(nums[index]); 
        }
        return res;
    }
}
// @lc code=end

