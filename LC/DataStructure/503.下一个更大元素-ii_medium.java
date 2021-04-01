/*
 * @Author: QingHui Meng
 * @Date: 2021-03-27 13:39:01
 */
/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
class Solution {

    /**
     * 对于循环数组，两次循环肯定就可以把全部元素的下一个更大元素找到
     * 思路1：构造一个真实数组，长度为nums的两倍。
     * 思路2：使用循环数组的技巧来模拟数组长度翻倍的效果。
     * 
     * @param {int[]} nums
     * @return {*}
     */
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        for(int i = 0; i<length; i++){
            res[i] = -1;
        }
        //单调栈
        Deque<Integer> stack = new LinkedList<>();
        //记录索引
        Deque<Integer> index = new LinkedList<>();
        //利用对长度取余数的方式来循环访问数组
        for(int i = 0; i<length*2; i++){
            //i%length为元素的真实位置
            while(!stack.isEmpty() && nums[i%length] > stack.peekLast()){
                res[index.pollLast() % length] = nums[i%length];
                stack.pollLast();
            }
            stack.offerLast(nums[i%length]);
            index.offerLast(i);
        }
        return res;
    }
}
// @lc code=end

