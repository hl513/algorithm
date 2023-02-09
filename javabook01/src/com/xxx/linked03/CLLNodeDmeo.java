package com.xxx.linked03;


/**
 * @author HeP
 * @date 2023/2/7 12:20
 * 循环链表
 */
public class CLLNodeDmeo {

    /**
     * 获取循环链表的长度
     *
     * @param head
     * @return
     */
    public static int getLength(CLLNode head) {
        int length = 0;
        CLLNode cur = head;  // 用于后面判断是否重合
        while (cur != null) {
            length++;
            cur = cur.getNext();
            // 如果当前节点与头节点相等，表示遍历完一圈，跳出循环
            if (cur == head) {
                break;
            }
        }
        return length;
    }

    /**
     * 输出循环链表的所有内容
     *
     * @param head
     */
    public static void printData(CLLNode head) {
        CLLNode cur = head;
        while (cur != null) {
            System.out.println(cur.getData() + "->");
            cur = cur.getNext();
            if (cur == head) break;
        }
        System.out.println("(" + cur.getData() + ")head");
    }

    /**
     * 在循环链表的尾部插入节点
     *
     * @param head
     * @param node
     */
    public static void insertEnd(CLLNode head, CLLNode node) {
        CLLNode cur = head;
        while (cur.getNext() != head) cur.setNext(cur.getNext());
        node.setNext(node);
        if (head == null) head = node;
        else {
            node.setNext(head);
            cur.setNext(node);
        }
    }

    /**
     * 在循环链表的头部插入节点
     *
     * @param head
     * @param node
     */
    public static void insertBefore(CLLNode head, CLLNode node) {
        CLLNode cur = head;
        while (cur.getNext() != head) cur.setNext(cur.getNext());
        node.setNext(node);
        if (head == null) head = node;
        else {
            node.setNext(head);
            cur.setNext(node);
            head = node;
        }
    }


    /**
     * 删除循环链表的最后一个节点
     *
     * @param head
     */
    public static void deleteLast(CLLNode head) {
        CLLNode tmp = head;
        CLLNode cur = head;
        if (head == null) {
            System.out.println("List Empty");
            return;
        }
        while (cur.getNext() != head) {
            tmp = cur;
            cur = cur.getNext();
        }
        tmp.setNext(head);
        cur = null;
        return;
    }

    /**
     * 删除循环链表的第一个节点
     *
     * @param head
     */
    public static void deleteFirst(CLLNode head) {
        CLLNode tmp = head;
        CLLNode cur = head;
        if (head == null) {
            System.out.println("List Empty");
            return;
        }
        while (cur.getNext() != head) cur.setNext(cur.getNext());
        cur.setNext(head.getNext());
        head = head.getNext();
        tmp = null;
        return;
    }

}
