/*
 * @Author: QingHui Meng
 * @Date: 2021-03-26 17:06:36
 */
/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start
class Solution {

    /**
     * 使用单调栈进行解决
     * 
     * @param {int[]} nums1
     * @param {int[]} nums2
     * @return {*}
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Deque<Integer> deque = new LinkedList<>();
        //存放nums2的中元素的下一个最大值
        Map<Integer, Integer> map = new HashMap<>();

        //先获得nums2中所有元素的下一个最大值
        for(int i = 0; i < nums2.length; i++){
            //如果当前元素大于栈中的元素，说明当前元素是栈中元素的下一个大值
            while(!deque.isEmpty() && nums2[i] > deque.peekLast()){
                map.put(deque.pollLast(), nums2[i]);
            }
            //把当前元素也放入栈中，寻找下一个最大值
            deque.offerLast(nums2[i]);
        }

        //获得nums1中元素的下一个最大值
        int[] res = new int[nums1.length];
        for(int i = 0; i<nums1.length; i++){
            res[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        }
        return res;
    }
}
// @lc code=end

