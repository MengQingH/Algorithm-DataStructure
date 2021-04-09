/*
 * @Author: QingHui Meng
 * @Date: 2021-04-09 14:57:45
 */
/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */

// @lc code=start
class Solution {

    /**
     * 可以用单调栈来作为容器，把字典序最小的放在栈底，来实现字典序最小的要求。
     * 
     * @param {*}
     * @return {*}
     */
    public String removeDuplicateLetters(String s) {
        //存放去重后的结果
        Deque<Character> stack = new LinkedList<>();
        //计数器维护字符串中每个字符出现的数量
        int[] count = new int[256];
        for(int i = 0; i<s.length(); i++){
            count[s.charAt(i)]++;
        }

        //布尔数组初始值为false，记录栈中是否存在某个字符，输入的字符为ASCII字符，所以用256大小
        boolean[] isInStack = new boolean[256];
        for(char c : s.toCharArray()){
            //每遍历一次字符，都将对应的计数器减一
            count[c]--;

            //如果已经存在，直接跳过
            if(isInStack[c]) continue;

            //判断字典序，如果字典序比前面的小，则弹出前面的元素
            while(!stack.isEmpty() && stack.peek() > c){
                //如果之后不存在栈顶元素，则停止pop
                if(count[stack.peek()] == 0)
                    break;
                //弹出栈顶元素并更新标记
                isInStack[stack.pop()] = false;
            }

            //如果不存在插入并标记
            stack.push(c);
            isInStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        //出栈的顺序是反的，需要reverse一下
        return sb.reverse().toString();
    }
}
// @lc code=end

