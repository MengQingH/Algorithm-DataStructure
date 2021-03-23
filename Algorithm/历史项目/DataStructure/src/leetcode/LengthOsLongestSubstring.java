package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 求最大子串：
 * 给定一个字符串，找出其中不含有重复字符的最长字串的长度
 */
public class LengthOsLongestSubstring {
    public static void main(String[] args) {

        String s = " ";
        char[] c = s.toCharArray();
        System.out.println(c.length);
        System.out.println(Arrays.toString(c));

        LengthOsLongestSubstring l = new LengthOsLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * 解题思路：
     * 滑动窗口：暴力法的缺点在于每次遍历需要反复检查字符串中是否含有有重复的字符串，包含很多重复的部分。即如果从0开始的索引最长字串为到索引5
     * 位置，那么从1开始还是要检查1-5的这些元素。
     * 解决此问题可以使用滑动窗口。窗口是一个字串的集合[i,j)，最开始是[0,0)。判断j+1是否包含在窗口中，如果在，那么右边界向右移动；
     * 如果存在，那么左窗口向左移动。最大字串的长度为j-i的最大值。
     * <p>
     * 踩坑1：集合是[i,j)，把j位置上的元素添加到集合中之后就+1，这样子对是从i到j-1。采用这种方式子串的长度为j-i，判断条件为j<s.length();
     * 而如果使用[i,j]，那么就要判断下标j+1的位置是否在集合中，判断复杂且容易出现越界问题。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int length = 0;
        Set set = new HashSet();
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                length = length > (j - i) ? length : (j - i);
            } else set.remove(s.charAt(i++));
        }
        return length;
    }

    /**
     * 解题思路：
     * 暴力法：遍历整个数组，从每一个元素开始向后寻找从该元素开始的位置上的最大元素，并和当前最大长度比较
     * 效率低
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_1(String s) {
        char[] elements = s.toCharArray();
        int length = 0;
        for (int i = 0; i < elements.length; i++) {
            Set set = new HashSet();
            set.add(elements[i]);
            int l = 1;
            for (int j = i + 1; j < elements.length; j++) {
                if (set.contains(elements[j])) {
                    break;
                } else {
                    set.add(elements[j]);
                    l++;
                }
            }
            length = length > l ? length : l;
        }
        return length;
    }

}
