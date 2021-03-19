/*
 * @Author: QingHui Meng
 * @Date: 2021-03-16 15:21:15
 */
/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
     * 反转索引从m到n的结点，如果m = 1，那么就相当于反转前n个结点，
     *  可以从第m个元素开始进行反转，此时就相当于反转前n-m个元素。
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == 1){
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left-1, right-1);
        return head;
    }

    private ListNode successor = null;

    /**
     * 反转链表的前n个结点
     */
    private ListNode reverseN(ListNode head, int n){
        if(n == 1){
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
// @lc code=end

