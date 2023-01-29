package com.xxx;


import java.util.Scanner;

/**
 * @author HeP
 * @date 2023/1/15 12:07
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }


    // 反转链表
    // 先创建临时节点保存头节点的下一个节点，
    // 头节点的下一个节点设置为空，
    // 新节点的下一个节点为头节点，
    // 头节点重新赋值为刚才创建的临时节点（保存头节点的下一个节点)
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            // 创建一个节点存放 Head的下一个节点
            ListNode next = head.next;
            // 头节点的下一个节点为空
            head.next = prev;
            // 临时节点为头节点
            prev = head;
            // 将头节点的下一个节点重新赋值给头节点
            head = next;
        }
        return prev;
    }

    // 快慢指针找中点
    public ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}
