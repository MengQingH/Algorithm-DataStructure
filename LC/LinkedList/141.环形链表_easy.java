/*
 * @Author: QingHui Meng
 * @Date: 2021-04-02 16:16:31
 */
/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    /**
     * 使用快慢指针解决，时间复杂度O(n)
     * 
     * @param {ListNode} head
     * @return {*}
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast,slow;
        fast = slow = head;
        //注意循环条件只需要判断fast和fast.next
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

