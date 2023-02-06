package com.xxx.beforeafter05;

/**
 * @author HeP
 * @date 2023/2/6 18:16
 */
public class LeetCode237 {

    public void deleteNode(ListNode02 node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}

class ListNode02 {
    int val;
    ListNode next;

    ListNode02(int x) {
        val = x;
    }
}