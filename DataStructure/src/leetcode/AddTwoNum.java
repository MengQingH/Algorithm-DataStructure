package leetcode;

/**
 * 两数相加：
 * 给出两个非空链表用来表示两个非负的整数。其中，他们各自的位数是按照逆序的方式存储的，并且每个结点只能存储一位数字。
 * 如果将这两个数加起来，则返回一个新的链表。
 */
public class AddTwoNum {

    /**
     * 解题思路：与归并排序中的归并过程类似。
     * 从前向后遍历两个链表，把相同位置结点中的值相加，如果进位标志f为1，则在原来的基础上加1，并置标志位为0；
     *      如果值大于等于十，则减去10，并置进位标志f为1，把计算后的值添加到新列表中。
     * 当两个链表有一个为空时，就把非空的列表剩余的元素添加到新列表中。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode add(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        int f = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (f == 1) {
                sum += 1;
                f = 0;
            }
            if (sum >= 10) {
                sum = sum - 10;
                f = 1;
            }
            ListNode newNode = new ListNode(sum);
            node.next = newNode;
            node = node.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        //坑1：一个列表为空，添加非空列表到返回列表中的过程中，也需要判断进位标志是否为1
        while (l1 != null) {
            int sum = l1.val;
            if (f == 1) {
                sum += 1;
                f = 0;
            }
            if (sum >= 10) {
                sum = sum - 10;
                f = 1;
            }
            ListNode newNode = new ListNode(sum);
            node.next = newNode;
            node = node.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val;
            if (f == 1) {
                sum += 1;
                f = 0;
            }
            if (sum >= 10) {
                sum = sum - 10;
                f = 1;
            }
            ListNode newNode = new ListNode(sum);
            node.next = newNode;
            node = node.next;
            l2 = l2.next;
        }
        //坑2：最后也需要判断标志位是否为1，如果为1，那么就添加一个1到最后
        if (f == 1) {
            ListNode newNode = new ListNode(1);
            node.next = newNode;
        }

        return head.next;
    }

    /**
     * 节点类
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }
}
