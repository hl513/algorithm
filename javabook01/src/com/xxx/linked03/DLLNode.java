package com.xxx.linked03;

/**
 * @author HeP
 * @date 2023/2/7 11:07
 */
public class DLLNode {
    private int data;
    private DLLNode next;
    private DLLNode prev;

    public DLLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public DLLNode getPrev() {
        return prev;
    }

    public void setPrev(DLLNode prev) {
        this.prev = prev;
    }
}
