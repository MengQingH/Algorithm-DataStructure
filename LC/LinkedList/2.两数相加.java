/*
 * @Author: QingHui Meng
 * @Date: 2021-03-19 16:57:02
 */
/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /**
     * 需要处理进位的问题。
     * 
     * @param {ListNode} l1
     * @param {ListNode} l2
     * @return {*}
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //对于链表问题，如果要返回头结点时，可以初始化一个预先指针pre，该指针指向真正的头结点head。
        //方便直接用循环，不用额外处理头结点的值，并且也方便返回。
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;//进位
        //如果两个链表有结点不为空，或者进位不为空
        while(l1 != null || l2 != null || carry != 0){
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + carry;

            carry = sum/10;
            sum = sum%10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return pre.next;
    }
}
// @lc code=end

