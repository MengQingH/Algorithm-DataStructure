package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成：
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * "((()))"  "(()())"  "(())()"  "()(())"  "()()()"
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        List<String> list = g.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * 解题思路：使用递归。不考虑是否符合情况时每一个位置上有两种情况，左或者右，可以使用递归来来遍历每一种情况。
     * 其中首先要有左括号，才能有右括号，当count2>count1时，不符合情况，直接舍弃。当count1>=count2时，继续添加。
     * 同时当count1或者count2大于n时，舍弃。
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, "", 0, 0, n);
        return list;
    }

    public void generate(List<String> list, String s, int count1, int count2, int n) {
        if (count1 > n || count2 > n) return;

        if (count1 == n && count2 == n) list.add(s);

        //使括号的次序正确
        if (count1 >= count2) {
            generate(list, s + "(", count1 + 1, count2, n);
            generate(list, s + ")", count1, count2 + 1, n);

        }
    }
}
