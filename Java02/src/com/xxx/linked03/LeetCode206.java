package com.xxx.linked03;

/**
 * @author HeP
 * @date 2023/2/6 18:07
 */
public class LeetCode206 {

    public ListNode reverseList(ListNode head) {
        // prev：当前节点的前一个节点指向的位置
        ListNode prev = null, node = head;
        while (node != null) {
            // 保存当前节点
            ListNode tmp = node;
            // 当前节点继续指向下一个节点
            node = node.next;
            // 当前节点的下一个节点为 prev
            tmp.next = prev;
            prev = tmp;
        }
        return prev;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

