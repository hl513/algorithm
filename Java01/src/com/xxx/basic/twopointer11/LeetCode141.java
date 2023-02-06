package com.xxx.basic.twopointer11;

/**
 * @author HeP
 * @date 2023/1/31 10:52
 * 链表中的快慢指针
 */
public class LeetCode141 {
    /**
     *  快慢指针解法：
     *      如果不含有环，跑的快的那个指针最终会遇到 null,说明链表不含环；如果含有环，快指针最终会超慢指针一圈，和慢指针相遇，说明链表有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow, fast;
        slow = fast = head;
        // 判断快指针不为空
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}