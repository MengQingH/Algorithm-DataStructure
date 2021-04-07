/*
 * @Author: QingHui Meng
 * @Date: 2021-04-07 14:12:16
 */
/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {

    /**
     * @param {*}
     * @return {*}
     */
    public List<Integer> findAnagrams(String s, String p) {
        //源字符串s 目标字符串t
        char[] sArray = s.toCharArray();
        char[] tArray = p.toCharArray();
        //记录窗口需要凑齐的字符
        Map<Character, Integer> need = new HashMap<>();
        //记录窗口中的字符
        Map<Character, Integer> window = new HashMap<>();
        for(char c : tArray)
            need.put(c, need.getOrDefault(c, 0)+1);
        int left = 0, right = 0;
        //表示窗口中满足need条件的字符个数
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while(right < sArray.length){
            char c = sArray[right];
            right++;
            //窗口数据的更新
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if(window.get(c).equals(need.get(c)))
                    valid++;
            }

            //判断左侧窗口是否要收缩
            while(right - left >= p.length()){
                //判断题目条件是否满足
                if(valid == need.size()){
                    res.add(left);
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
        return res;

    }
}
// @lc code=end

