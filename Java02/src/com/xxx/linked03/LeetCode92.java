package com.xxx.linked03;

/**
 * @author HeP
 * @date 2023/2/6 18:09
 */
public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode cur = fakeHead.next;
        int i = 1;
        while (i < m) {
            prev = cur;
            cur = cur.next;
            i++;
        }
        ListNode node = prev;
        while (i++ <= n) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        node.next.next = cur;
        node.next = prev;
        return fakeHead.next;
    }
}
