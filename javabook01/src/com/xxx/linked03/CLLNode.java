package com.xxx.linked03;

/**
 * @author HeP
 * @date 2023/2/7 11:07
 */
public class CLLNode {
    private int data;
    private CLLNode next;
    public CLLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public CLLNode getNext() {
        return next;
    }

    public void setNext(CLLNode next) {
        this.next = next;
    }

}
