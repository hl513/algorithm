package com.xxx.basic.divde05;


import java.util.PriorityQueue;

/**
 * @author HeP
 * @date 2023/1/29 20:03
 */
public class LeetCode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        // 初始化大小为k的堆
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) q.offer(lists[i]);
        }
        ListNode cur = dummy;
        while (!q.isEmpty()) {
            cur.next = q.poll();   // 拿出堆顶元素
            cur = cur.next;   // 将堆顶元素的下一个加入堆中
            if (q.isEmpty()) break; // 只剩下最后一个无需遍历
            if (cur.next != null) q.offer(cur.next);
        }
        return dummy.next;
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
