package cn.jccomp.list;

import cn.jccomp.utils.ListUtil;

/**
 * Created by bitbook on 2/23/18.
 */
public class ListMerge {
    public static ListNode merge(ListNode list1, ListNode list2) {
        // pass over head first
        list1 = list1.next;
        list2 = list2.next;
        ListNode mergeHead = null;
        ListNode cur = null;
        if (list1 == null) {
            return list2;
        } else if (list2 == null){
            return list1;
        }
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (mergeHead == null) {
                    mergeHead = cur = list1;
                } else {
                    cur.next = list1;
                    cur = cur.next;
                }
                list1 = list1.next;
            } else {
                if (mergeHead == null) {
                    mergeHead = cur = list2;
                } else {
                    cur.next = list2;
                    cur = cur.next;
                }
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            cur.next = list1;
        }

        if (list2 != null) {
            cur.next = list2;
        }

        return mergeHead;
    }

    public static void main(String[] args) {
        ListNode list1 = ListUtil.fromArray(new int[]{1,3,4,6});
        ListNode list2 = ListUtil.fromArray(new int[]{2,5});
        ListNode merged = merge(list1, list2);
        ListUtil.printList(merged);
        System.out.println("-------");
        ListNode list3 = ListUtil.fromArray(new int[]{1,2,3,4});
        ListNode list4 = ListUtil.fromArray(new int[]{2,5,5,9});
        ListNode merged1 = merge(list3, list4);
        ListUtil.printList(merged1);
    }
}
