/*
 * @Author: QingHui Meng
 * @Date: 2021-04-25 17:10:46
 */
/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {

    /**
     * 动态规划写法
     * 
     * @param {*}
     * @return {*}
     */
    public int fib_(int n) {
        // base case
        if(n == 0)
            return 0;
        
        int prev = 0;
        int cur = 1;
        for(int i = 2; i<=n; i++){
            int sum = prev + cur;
            prev = cur;
            cur = sum;
        }
        return cur;
    }
    
    private Map<Integer, Integer> fn = new HashMap<>();

    /**
     * 备忘录写法
     * 
     * @param {*}
     * @return {*}
     */
    public int fib(int n) {
        fn.put(0, 0);
        fn.put(1, 1);
    
        for(int i = 2; i<=n; i++){
            int fi = fn.get(i-1) + fn.get(i-2);
            fn.put(i, fi);
        }
        return fn.get(n);
    }
}
// @lc code=end

