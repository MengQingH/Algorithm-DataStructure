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
     * 时间复杂度：O(n)
     * 
     * @param {int[]} nums
     * @param {int} k
     * @return {*}
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i<nums.length; i++){
            //向队列中添加元素：如果添加的元素i大于队列中i之前的所有元素，
            //那么就代表之后队列滑动的过程中，i之前的元素永远不会是最值，所以可以全部弹出
            while(!deque.isEmpty() && deque.peekLast()<nums[i]){
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            //i=k-1时，队列中元素个数满足条件，获得第一个最大值，之后每滑动一次，有一个最大值
            if(i >= k-1){
                res[i-k+1] = deque.peekFirst();
                //如果最大值为要弹出的值，就进行弹出
                if(deque.peekFirst() == nums[i-k+1]){
                    deque.pollFirst();
                }
            }
        }
        return res;
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

