package com.xxx.queue05;


/**
 * @author HeP
 * @date 2023/2/9 10:30
 */
public class LLNode {
    private Integer data;
    private LLNode next;

    public LLNode(Integer val) {
        this.data = val;
    }

    public Integer getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LLNode getNext() {
        return next;
    }

    public void setNext(LLNode next) {
        this.next = next;
    }
}
