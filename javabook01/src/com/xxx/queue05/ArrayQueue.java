package com.xxx.queue05;

/**
 * @author HeP
 * @date 2023/2/9 13:02
 * 基于循环数组实现队列
 */
@SuppressWarnings("all")
public class ArrayQueue {

    private int front; // 队头指针
    private int rear; // 队尾指针
    private int capacity;
    private int[] array;

    public ArrayQueue(int size) {
        capacity = size;
        front = -1;
        rear = -1;
        array = new int[size];
    }

    // 初始化队列
    public static ArrayQueue createQueue(int size) {
        return new ArrayQueue(size);
    }

    public boolean isEmpty() {
        // 队头为-1，表示为空
        return (front == -1);
    }

    public boolean isFull() {
        return ((rear + 1) % capacity == front);
    }

    public int getQueueSize() {
        return ((capacity - front + rear + 1) % capacity);
    }

    // 入队
    public void enQueue(int data) {
        if (isFull()) throw new RuntimeException("Queue Overflow");
        else {
            rear = (rear + 1) % capacity;
            array[rear] = data;
            if (front == -1) front = rear;
        }
    }

    // 出队
    public int deQueue() {
        Integer data = null;
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        else {
            data = array[front];
            if (front == rear) {
                front = rear - 1;
            } else {
                front = (front + 1) % capacity;
            }
        }
        return data;
    }

}
