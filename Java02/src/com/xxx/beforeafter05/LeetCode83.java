package com.xxx.beforeafter05;

/**
 * @author HeP
 * @date 2023/2/6 18:20
 */
public class LeetCode83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        while (cur.next != null)
            if (cur.next.val == cur.val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        return head;
    }

}
