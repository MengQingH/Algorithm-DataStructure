/*
 * @Author: QingHui Meng
 * @Date: 2021-04-13 17:23:11
 */
/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {

    private List<String> res = new ArrayList<>();

    /**
     * 性质1：一个合法的括号组合的左括号数量一定等于右括号的数量
     * 性质2：对于一个「合法」的括号字符串组合p，必然对于任何0 <= i < len(p)都有：
     *      子串p[0..i]中左括号的数量都大于或等于右括号的数量。
     * 
     * @param {*}
     * @return {*}
     */
    public List<String> generateParenthesis(int n) {
        String track = "";
        backtrack(track, n, 0, 0);
        return res;
    }

    /**
     * 回调方法
     * 
     * @param {String} track
     * @param {int} n
     * @param {int} lSize
     * @param {int} rSize
     * @return {*}
     */
    private void backtrack(String track, int n, int lSize, int rSize){
        //如果左括号或者右括号大于n个，不合法
        if(lSize > n || rSize > n) return;
        //如果左括号的数量小于右括号，不合法
        if(lSize < rSize) return;

        //如果数量等于2n，满足条件
        if(track.length() == n*2){
            res.add(new String(track));
        }

        //添加一个左括号
        track = track + "(";
        backtrack(track, n, lSize+1, rSize);
        //撤回选择
        track = track.substring(0, track.length()-1);

        //添加一个右括号
        track = track + ")";
        backtrack(track, n, lSize, rSize+1);
        track = track.substring(0, track.length()-1);

    }
}
// @lc code=end

