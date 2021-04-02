/*
 * @Author: QingHui Meng
 * @Date: 2021-04-02 16:53:49
 */
/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
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
     * 环的长度：如果快慢指针相遇时，慢指针走了k步，那么快指针就走了2k步，k就是环的长度。
     * 假设相遇点距环的距离为m，那么环的起点距离头结点head的距离为k-m，也就是说head前进k-m步就能达到环起点；
     * 而如果从相遇点继续前进k-m步，也恰好达到环起点。
     * 所以，把快慢指针中的任意一个指向head，两个指针同速前进，k-m步后就会相遇，相遇之处就是环起点了。
     * 
     * @param {ListNode} head
     * @return {*}
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        boolean isCycle = false;
        //注意循环条件
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                isCycle = true;
                break;
            }
        }

        if(!isCycle)
            return null;
        
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
// @lc code=end

