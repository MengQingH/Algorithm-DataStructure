/*
 * @Author: QingHui Meng
 * @Date: 2021-04-25 17:40:14
 */
/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {

    /**
     * dp数组的定义：dp[i][j]表示在word1 0-i 和word2 0-j中，最小操作数为dp[i][j]
     * 
     * 对于word1[i]和word2[j]而言，如果要将word1转换为word2，有下面两种情况：
     * 1. word1[i] == word2[j] 此时不需要继续操作，直接进行下一步就可以；
     * 2. word1[i] != word2[j] 此时需要进行操作，操作有下面三种情况：
     *  * 在i处插入word2[j]，那么word2[j]就被匹配了，前移j，继续跟i对比，操作数+1:dp[i, j-1]+1
     *  * 删除word1[i]，前移i，继续和j对比，操作数+1:dp[i-1, j]+1
     *  * 把word1[i]替换为word2[j]，前移i和j，继续进行对比，操作数+1
     * 
     * @param {String} word1
     * @param {String} word2
     * @return {*}
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        // base case word1或者word2为0时，需要的操作数为i
        for(int i = 1; i<=len1; i++)
            dp[i][0] = i;
        for(int j = 1; j<=len2; j++)
            dp[0][j] = j;
        
        for(int i = 1; i<=len1; i++){
            for(int j = 1; j<=len2; j++){
                // 如果相等，不需要操作
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    // 如果不相等，那么就要执行三种操作，然后选择操作数最小的
                    dp[i][j] = Math.min(
                        dp[i][j-1]+1,//插入操作
                        Math.min(
                            dp[i-1][j]+1,//删除操作
                            dp[i-1][j-1]+1//替换操作
                        )
                    );
                }
            }
        }
        return dp[len1][len2];
    }
}
// @lc code=end

