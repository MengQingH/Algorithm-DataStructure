/*
 * @Author: QingHui Meng
 * @Date: 2021-03-16 15:16:08
 */
/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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

    ////////////////////////////递归实现///////////////////////////////////

      /**
       * k个一组翻转链表，反转的具体实现reverseN用的是递归，而不是迭代
       * 该递归函数的定义是：以k个一组的翻转以head为头结点的链表，并返回翻转后的新头结点
       *
       * @param head
       * @param k
       * @return
       */
      public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        //找到下一组的头结点，如果剩下的长度不足k，就直接返回头结点
        for(int i = 0; i < k; i++){
              if(tail == null){
                    return head;
              }
              tail = tail.next;
        }
        //翻转以head为头结点的前k个结点
        ListNode newHead = reverseN(head,k);
        //对翻转后的结点进行连接
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    private ListNode successor = null;

    /**
     * 翻转以head为头结点的n个结点，返回新的头结点
     * @param head
     * @param n
     * @return
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


    //////////////////////////////////迭代实现/////////////////////////////////
    
    public ListNode reverseKGroup_iter(ListNode head, int k){
            ListNode tail = head;
            for (int i = 0; i < k; i++) {
                if (tail == null){
                    return head;
                }
                tail = tail.next;
            }
            //翻转以head为头结点的一组
            ListNode newHead = reverse(head, tail);
            head.next = reverseKGroup_iter(tail, k);
            return newHead;
    }

    /**
     * 使用迭代的方式翻转从head到tail的链表（不包括tail）,返回新的头结点
     * @param head
     * @param tail
     * @return
     */
    public ListNode reverse(ListNode head, ListNode tail){
            ListNode pre = null, cur = head, next = head;
            //使用迭代进行head到tail的翻转
            while (cur != tail){
                next = cur.next;
                head.next = pre;
                pre = cur;
                cur = next;
            }
            //返回的头结点应该是pre，而不是cur
            return pre;
    }
}
// @lc code=end

