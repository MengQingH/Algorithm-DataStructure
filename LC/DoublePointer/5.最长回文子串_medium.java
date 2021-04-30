/*
 * @Author: QingHui Meng
 * @Date: 2021-04-29 16:33:41
 */
/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {

    /**
     * 使用双指针技巧来解决，遍历每一个点找出该点对应的回文串。
     * 
     * @param {*}
     * @return {*}
     */
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String res = "";
        for(int i = 0; i<s.length(); i++){
            // 回文串长度为奇数
            String res1 = palindrome(s, chars, i-1, i+1);
            // 回文串长度为偶数
            String res2 = palindrome(s, chars, i, i+1);
            
            res1 = res1.length() > res2.length() ? res1 : res2;
            res = res.length() > res1.length() ? res : res1;
        }
        return res;
    }

    /**
     * 判断回文串
     * 
     * @param {*}
     * @return {*}
     */
    private String palindrome(String s, char[] chars, int l, int r){
        // 先判断索引，防止越界
        while(l>=0 && r<=chars.length-1 && chars[l] == chars[r]){
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }
}
// @lc code=end

