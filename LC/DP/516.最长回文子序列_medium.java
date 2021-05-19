/*
 * @Author: QingHui Meng
 * @Date: 2021-05-06 10:57:01
 */
/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 */

// @lc code=start
class Solution {

    /**
     * dp数组定义：dp[i][j]表示字串s[i-j]中，最长回文子序列的长度为dp[i][j]
     * 状态转移关系：如果已知dp[i-1][j+1]，如果s[i]==s[j]，那么dp[i][j] = dp[i-1][j+1]+2
     *  如果不相等，那么dp[i] dp[j]不可能同时出现在dp[i-j]的最长回文子序列中，
     *  那就看哪个字串产生的最长回文子序列更长dp[i][j] = max(dp[i+1][j], dp[i][j-1]
     * 
     * base case：如果只有一个字符，那么最长回文子序列长度是1；
     * 因为i肯定小于j，所以对于i>j的位置不需要考虑
     * 如果要求dp[i][j]，需要知道dp[i+1][j-1]、dp[i+1][j]、dp[i][j-1]，反映在二维表中，
     * 即二维表i j位置的左边、左下和下面三个位置，为了满足这个条件，只能斜着或者反着遍历
     * 
     * @param {*}
     * @return {*}
     */
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int[][] dp = new int[len][len];
        // base case
        for(int i = 0; i<len; i++){
            dp[i][i] = 1;
        }
        // 反着遍历，保证满足正确的状态转移
        for(int i = len-1; i>=0; i--){
            for(int j = i+1; j<len; j++){
                // 状态转移方程
                if(arr[i] == arr[j]){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        // 返回整个s的最长回文字串
        return dp[0][len-1];
    }
}
// @lc code=end

