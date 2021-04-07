/*
 * @Author: QingHui Meng
 * @Date: 2021-04-07 14:40:52
 */
/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {

    /**
     * @param {*}
     * @return {*}
     */
    public int lengthOfLongestSubstring(String s) {
        char[] sArray = s.toCharArray();
        //记录窗口中的字符
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int len = 0;
        while(right < sArray.length){
            char c = sArray[right];
            right++;
            window.put(c, window.getOrDefault(c, 0)+1);
            while(window.get(c) > 1){
                char d = sArray[left];
                left++;
                window.put(d, window.getOrDefault(d, 0)-1);
            }
            len = Math.max(len, right-left);
        }
        return len;
    }
}
// @lc code=end

