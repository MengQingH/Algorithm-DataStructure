/*
 * @Author: QingHui Meng
 * @Date: 2021-03-16 15:49:45
 */
/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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

    ///////////////////////////////////////////时间复杂度O(n) 空间复杂度O(1)///////////////////////////////////////////

    /**
     * 优化方案：使用反转链表的方式来比较
     * 
     * @param {ListNode} head
     * @return {*}
     */
    public boolean isPalindrome_(ListNode head){
        //首先使用快慢指针来获得链表的中心结点
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //如果链表的长度为奇数，中心点还要向后移
        if (fast != null){
            slow = slow.next;
        }
        //对slow后面的链表进行反转
        ListNode right = reverse(slow);
        ListNode left = head;
        //进行回文串判断
        while (right != null){
            if (right.val != left.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    /**
     * 反转链表
     * 
     * @param {ListNode} head
     * @return {*}
     */
    public ListNode reverse(ListNode head){
        ListNode pre = null, cur = head, next;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    ///////////////////////////////////////////时间复杂度O(n) 空间复杂度O(n)///////////////////////////////////////////
    
    public boolean isPalindrome(ListNode head){
        left = head;
        return traverse(head);
    }

    //从左边开始遍历结点
    ListNode left = null;

    /**
     * 使用后序遍历的方式进行判断
     * 思路：traverse函数会一直进行递归，直到最后一个null值，返回true，然后执行最后一个非空结点的递归方法，此时right结点的位置就是
     *      最后一个非空结点，而left结点的位置是head结点，判断是否相等。然后两个指针向两个方向移动，进行判断。
     * 
     * @param {ListNode} right
     * @return {*}
     */
    private boolean traverse(ListNode right){
        if(right == null) return true;
        boolean res = traverse(right.next);
        //由于使用的遍历是后序遍历，所以第一次执行到这行代码时是在最后一个非空结点，此时right为这个结点，left为head结点
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }
}
// @lc code=end

