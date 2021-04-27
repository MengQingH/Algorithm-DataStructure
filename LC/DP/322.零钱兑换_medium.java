/*
 * @Author: QingHui Meng
 * @Date: 2021-04-25 17:41:20
 */
/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {

    /**
     * dp数组定义：dp[i]表示凑出i需要的最少的零钱。
     * 归纳：dp[i]的最小值就是min(dp[i-coin]+1)
     * 
     * @param {int[]} coins
     * @param {int} amount
     * @return {*}
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        // dp[i]的最大值为amount，把所有的值设置为amount+1方便求最小值
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i = 0; i<=amount; i++){
            for(int coin : coins){
                if(i-coin >= 0)
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[amount] > dp ? -1 : dp[amount];
    }

    /**
     * 效率较低
     * 
     * @param {int[]} coins
     * @param {int} amount
     * @return {*}
     */
    public int coinChange1(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 0);
        for(int i = 1; i<=amount; i++){
            int min = -1;
            for(int coin : coins){
                int count = memo.getOrDefault(i-coin, -1);
                if(count == -1)
                    continue;
                if(min == -1)
                    min = count+1;
                else {
                    min = Math.min(min, count+1);
                }
            }
            memo.put(i, min);
        }
        return memo.get(amount);
    }
}
// @lc code=end

