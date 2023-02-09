package com.xxx.linked03;

/**
 * @author HeP
 * @date 2023/2/7 11:08
 * 双向链表
 */
public class DLLNodeDemo01 {

    public static void main(String[] args) {
        DLLNode head = new DLLNode(0);
        for (int i = 0; i < 10; i++) {
            insert(head, new DLLNode(i), i + 1);
        }
        System.out.println(getLength(head));
        System.out.println("--------------");
        printNode(head);
        delete(head,5);
        System.out.println();
        System.out.println("--------------");
        printNode(head);

    }


    /**
     * 双向链表的插入
     *
     * @param head     头节点
     * @param node     新节点
     * @param position 位置
     * @return
     */
    public static DLLNode insert(DLLNode head, DLLNode node, int position) {
        if (head == null) return node; // 最初链表为空时插入
        int size = getLength(head);
        // 判断插入位置的合法性
        if (position > size + 1 || position < 1) {
            System.out.println("Position of nodeToInsert is invalid." + "The valid inputs are 1 to  " + (size + 1));
            return head;
        }
        if (position == 1) {  // 在链表开头插入
            // 设置当前节点的下一个为头节点
            node.setNext(head);
            // 头节点的上一个节点为 node
            head.setPrev(node);
            return node;
        } else {
            // 在链表中间或末尾插入
            DLLNode prev = head;
            int count = 1;
            while (count < position - 1) {
                prev = prev.getNext();
                count++;
            }
            // 将当前节点得下一个节点赋值为 cur
            DLLNode cur = prev.getNext();
            // 设置下一个节点为 cur
            node.setNext(cur);
            // 判断是否是最后一个元素，不是的话 设置node为cur的上一个节点
            if (cur != null) cur.setPrev(node);
            // 上下节点的设置
            prev.setNext(node);
            node.setPrev(prev);
        }
        return head;
    }

    // 获取链表节点数量
    private static int getLength(DLLNode head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.getNext();
        }
        return cnt;
    }

    /**
     * 删除链表指定节点的数据
     * @param head
     * @param position
     * @return
     */
    private static DLLNode delete(DLLNode head, int position) {
        int size = getLength(head);
        // 判断删除位置是否合法
        if (position > size || position < 1) {
            System.out.println("Position of delete is invalid." + "The valid inputs are 1 to  " + size);
            return head;
        }
        if (position == 1) { // 删除链表的第一个节点
            // 获取头节点的下一个节点
            DLLNode cur = head.getNext();
            // 将头节点置为空
            head = null;
            // 新头节点的上一个节点为空
            cur.setPrev(null);
            return cur;
        } else {
            // 删除中间节点或末尾节点
            DLLNode prev = head;
            int count = 1;
            while (count < position - 1) {
                prev = prev.getNext();
                count++;
            }
            // 获取下一个节点
            DLLNode cur = prev.getNext();
            // 再获取下下个节点
            DLLNode later = cur.getNext();
            // 然后设置直接跳过即可
            prev.setNext(later);
            // 如果被删除节点的后继结点不是null，那么设置其前缀
            // 指针指向被删除节点的前驱节点
            if (later != null) later.setPrev(prev);
            cur = null;
        }
        return head;
    }

    /**
     * 遍历链表的数据
     *
     * @param head
     */
    public static void printNode(DLLNode head) {
        DLLNode cur = head;
        while (cur != null) {
            System.out.print(cur.getData() + "->");
            cur = cur.getNext();
        }
    }

}
