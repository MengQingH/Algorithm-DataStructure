/*
 * @Author: QingHui Meng
 * @Date: 2021-04-17 14:42:32
 */
/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {

    /**
     * 快速选择算法：快速排序经过一次递归调用后，元素就会出现在他应该在的位置，那么就可以通过索引得到他的次序。
     * 
     * @param {int[]} nums
     * @param {int} k
     * @return {*}
     */
    public int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length-1;
        k = nums.length - k;
        while(lo < hi){
            int p = partition(nums, lo, hi);
            if(p < k){
                lo = p+1;
            }else if(p > k){
                hi = p-1;
            }else {
                return nums[p];
            }
        }
        return -1;
    }

    /**
     * 思路1：使用二叉堆。把所有元素放入最小堆中，不断弹出到只剩下k个元素，
     * 那么剩下的k个元素就是k个最大元素，而栈顶元素也就是k个元素中最小的。
     * 
     * @param {int[]} nums
     * @param {int} k
     * @return {*}
     */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.offer(num);
            // 当元素个数大于k时，弹出
            if(pq.size() > k){
                pq.poll();
            }
        }
        // pq中剩下的是数组中最大的k个元素，堆顶是最小的。
        return pq.peek();
    }
}
// @lc code=end

