/*
 * @Author: QingHui Meng
 * @Date: 2021-03-27 10:53:34
 */
/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    
    /**
     * 使用单调栈来解决
     * 
     * @param {*}
     * @return {*}
     */
    public int[] dailyTemperatures(int[] T) {

        int[] res = new int[T.length];
        Deque<Integer> stack = new LinkedList<>();
        //存放stack中对应元素的索引
        Deque<Integer> index = new LinkedList<>();

        for(int i = 0; i<T.length; i++){
            //如果当前温度比栈中上面的元素高，说明当前温度为栈中温度的下一个较大值。
            while(!stack.isEmpty() && stack.peekLast() < T[i]){
                //操作时必须同时对栈和索引栈进行操作
                int curIndex = index.pollLast();
                res[curIndex] = i-curIndex;
                stack.pollLast();
            }
            stack.offerLast(T[i]);
            index.offerLast(i);
        }
        return res;
    }
}
// @lc code=end

