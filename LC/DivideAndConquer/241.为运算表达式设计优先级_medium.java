/*
 * @Author: QingHui Meng
 * @Date: 2021-04-23 10:19:26
 */
/*
 * @lc app=leetcode.cn id=241 lang=java
 *
 * [241] 为运算表达式设计优先级
 */

// @lc code=start
class Solution {

    //备忘录
    private HashMap<String, List<Integer>> memo = new HashMap<>();

    /**
     * 函数定义：计算算式expression所有可能的运算结果
     * 思路：每遇到一个运算符，就把括号加在运算符的两边，然后对两部分进行递归。
     * 
     * @param {String} expression
     * @return {*}
     */
    public List<Integer> diffWaysToCompute(String expression) {
        //避免重复计算
        if(memo.containsKey(expression))
            return memo.get(expression);
        
        List<Integer> res = new ArrayList<>();
        // 遍历所有的字符，找出运算符
        for(int i = 0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '-' || c == '*' || c == '+'){
                // 对符号左右进行递归，获取所有的结果
                List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1,expression.length()));

                // 对左右两边递归结果进行整合
                for(Integer l : left){
                    for(Integer r : right){
                        if(c == '+')
                            res.add(l + r);
                        if(c == '-')
                            res.add(l - r);
                        if(c == '*')
                            res.add(l * r);
                    }
                }
            }
        }

        // base case 如果res为空，说明expression只有一个数字
        if(res.isEmpty()){
            res.add(Integer.parseInt(expression));
        }

        // 将计算结果加入备忘录
        memo.put(expression, res);
        return res;
    }
}
// @lc code=end

