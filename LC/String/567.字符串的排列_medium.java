/*
 * @Author: QingHui Meng
 * @Date: 2021-04-07 11:24:36
 */
/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {

    /**
     * @param {String} s1
     * @param {String} s2
     * @return {*}
     */
    public boolean checkInclusion(String s1, String s2) {
        char[] sArray = s2.toCharArray();
        char[] tArray = s1.toCharArray();
        //记录窗口需要凑齐的字符
        Map<Character, Integer> need = new HashMap<>();
        //记录窗口中的字符
        Map<Character, Integer> window = new HashMap<>();
        for (char c : tArray){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        //表示窗口中满足need条件的字符个数
        int valid = 0;
        while (right < sArray.length){
            char c = sArray[right];
            right ++;
            //窗口数据的更新
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if(window.get(c).equals(need.get(c)))
                    valid++;
            }
            
            //判断左侧窗口是否要收缩
            while(right - left >= s1.length()/** window needs shrink**/){
                //判断是否找到了合法的字串
                if(valid == need.size()){
                    return true;
                }
                char d = sArray[left];
                left++;
                //进行窗口内数据的一系列更新
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.getOrDefault(d, 0)-1);
                }
            }
        }
        //没有找到符合条件的字符串
        return false;
    }
}
// @lc code=end

