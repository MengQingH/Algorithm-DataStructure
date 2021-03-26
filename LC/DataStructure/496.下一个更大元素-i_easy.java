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
        int[] res = new int[nums1.length];
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i < nums1.length; i++){
            //从尾部把nums2中的元素放入栈中
            int index = num2.length - 1;
            while(index >= 0 && nums2[index] != nums1[i]){
                if(nums2[index] > nums1[i])
                    deque.add(nums2[index]);
                index--;
            }
            if(index = )
        }
    }
}
// @lc code=end

