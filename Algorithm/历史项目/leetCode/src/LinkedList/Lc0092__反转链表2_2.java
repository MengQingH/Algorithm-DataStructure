package LinkedList;

import node.ListNode;

public class Lc0092__反转链表2_2 {

    /**
     * 反转索引从m到n的结点，如果m = 1，那么就相当于反转前n个结点，可以从第m个元素开始进行反转，此时就相当于反转前n-m个元素。
     *
     * @param head
     * @param left
     * @param right
     * @return
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

}
