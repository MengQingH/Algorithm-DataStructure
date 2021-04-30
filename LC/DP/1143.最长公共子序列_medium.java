/*
 * @Author: QingHui Meng
 * @Date: 2021-04-26 16:01:43
 */
/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class Solution {

    /**
     * dp数组的定义：dp[i][j]表示text1[0...i]和text2[0...j]中的最长公共子序列为dp[i][j]
     * 
     * 思路：假设子序列为lcs，如果一个字符存在于lcs中，那么他肯定存在于s1和s2中。
     *  可以遍历s1和s2，如果s1[i] == s2[j]，那么这个字符一定在lcs中，
     *  否则，s1[i] s2[j]这两个字符至少有一个不在lcs中，需要丢弃一个：
     * 
     * // 递归思路
     * private int dp(int i, int j){
     *   if(i==-1 || j == -1)
     *       return 0;
     *   if(str1[i] == str2[j])
     *       return dp(i-1, j-1)+1;
     *   else
     *       return max(dp(i-1, j), dp(i, j-1));
     * }
     * 
     * @param {String} text1
     * @param {String} text2
     * @return {*}
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        // 边界问题：如果i或j为0，那么最长子序列也为0
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 1; i<=len1; i++){
            char c1 = text1.charAt(i - 1);
            for(int j = 1; j<=len2; j++){
                char c2 = text2.charAt(j - 1);
                if(c1 == c2)
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[len1][len2];
    }    
}
// @lc code=end

