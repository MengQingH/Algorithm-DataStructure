/*
 * @Author: QingHui Meng
 * @Date: 2021-04-06 14:34:00
 */
/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

//  @lc code=start
class Solution {

    /**
     * 使用滑动窗口来解决
     * 需要注意的是：java中int类型有常量池，所以用==来判断会不准确
     * 
     * @param {*}
     * @return {*}
     */
    public String minWindow(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        // 记录窗口需要凑齐的字符
        Map<Character, Integer> need = new HashMap<>();
        // 记录窗口中的字符
        Map<Character, Integer> window = new HashMap<>();
        for (char c : tArray){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0;
        // 表示窗口中满足need条件的字符个数
        int valid = 0;
        // 记录最小的长度和开始索引
        int start = 0, end = 0, len = Integer.MAX_VALUE;
        while (right < sArray.length){
            // c 是即将移入的字符
            char c = sArray[right];
            right ++;
            // 窗口数据的更新
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                // need.get(c) 为1，window.get(c)只有在第一次添加的时候是1，所以只会添加一次
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            
            // 判断左侧窗口是否要收缩
            while(valid == need.size()/** window needs shrink**/){
                // 在这里更新最小覆盖字串
                if(right - left < len){
                    start = left;
                    end = right;
                    len = right-left;
                }
                // d是即将移除的字符
                char d = sArray[left];
                left++;
                // 进行窗口内数据的一系列更新
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
}
//  @lc code=end

