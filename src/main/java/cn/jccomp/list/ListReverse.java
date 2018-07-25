package cn.jccomp.list;

import cn.jccomp.list.ListNode;

/**
 * Created by bitbook on 2/23/18.
 * 将链表反转
 */
public class ListReverse {
    public static ListNode reverse(ListNode head) {
        ListNode pre, cur, post;
        pre = null;
        cur = head;// cur是当前要处理的节点，所以应该是第一个即head节点
        post = cur.next;
        while (cur != null) { // 当以post != null作为while的循环条件时，最后一个节点得不到处理。
            cur.next = pre;
            pre = cur;
            cur = post;
            if (cur != null) post = cur.next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int[] array = new int[]{1,2,3,4};
        for (int i = 0; i != array.length; i++) {
            ListNode temp = new ListNode(array[i]);
            cur.next = temp;
            cur = temp;
        }
        ListNode tail = reverse(head);
        while (tail != null) {
            System.out.println(tail.val);
            tail = tail.next;
        }
    }


}
