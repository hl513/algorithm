package com.xxx.queue05;

/**
 * @author HeP
 * @date 2023/2/9 17:13
 * 基于链表实现队列
 */
public class LLQueue {

    private LLNode frontNode;
    private LLNode rearNode;
    int size = 0;

    public LLQueue() {
        this.frontNode = null;
        this.rearNode = null;
    }

    public static LLQueue createQueue() {
        return new LLQueue();
    }

    public boolean isEmpty() {
        return (frontNode == null);
    }

    public int getQueueSize() {
        return size;
    }


    // 入队
    public void enQueue(int data) {
        LLNode newNode = new LLNode(data);
        if (rearNode != null) rearNode.setNext(newNode);
        rearNode = newNode;
        if (frontNode == null) frontNode = rearNode;
        size++;
    }

    // 出队
    public int deQueue() {
        Integer data = null;
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        else {
            data = frontNode.getData();
            frontNode = frontNode.getNext();
        }
        size--;
        return data;
    }

}
