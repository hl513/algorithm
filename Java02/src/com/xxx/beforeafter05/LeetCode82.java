package com.xxx.beforeafter05;

/**
 * @author HeP
 * @date 2023/2/6 18:21
 */
public class LeetCode82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dumy = new ListNode(0);
        dumy.next  = head; // 头节点
        ListNode pre = dumy,cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                int temp = cur.val;
                while(cur != null && temp == cur.val) cur = cur.next;
                pre.next = cur;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dumy.next;
    }
}
