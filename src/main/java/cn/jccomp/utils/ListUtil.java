package cn.jccomp.utils;

import cn.jccomp.list.ListNode;

/**
 * Created by bitbook on 2/23/18.
 */
public class ListUtil {

    public static ListNode fromArray(int[] array) {
        return fromArray(array, true);
    }

    // 返回带头节点的链表
    public static ListNode fromArray(int[] array, boolean withHead) {// java里面不支持默认参数，可以用方法重载实现。
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int val:
             array) {
            ListNode temp = new ListNode(val);
            cur.next = temp;
            cur = cur.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


}
