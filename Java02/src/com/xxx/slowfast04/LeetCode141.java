package com.xxx.slowfast04;

/**
 * @author HeP
 * @date 2023/2/6 18:12
 */
public class LeetCode141 {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast  =head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，表示有环
            if (slow == fast) return true;
        }
        return false;
    }
}
