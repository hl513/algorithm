package com.xxx.stack04;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author HeP
 * @date 2023/2/9 10:28
 * 用链表实现栈
 */
public class LLStack extends Stack {

    private LLNode head;

    public LLStack() {
        this.head = new LLNode(null);
    }

    public void push(int val) {
        if (head == null) head = new LLNode(val);
        else if (head.getData() == null) head.setData(val);
        else {
            LLNode node = new LLNode(val);
            node.setNext(head);
            head = node;
        }
    }

    public Integer top() {
        if (head == null) return null;
        else return head.getData();
    }

    public Integer pop() {
        if (head == null) throw new EmptyStackException();
        else {
            int val = head.getData();
            head = head.getNext();
            return val;
        }
    }

    public boolean isEmpty() {
        if (head == null) return true;
        else return false;
    }

    public void deleteStack() {
        head = null;
    }

}
