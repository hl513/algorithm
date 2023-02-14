package com.xxx.queue05;

/**
 * @author HeP
 * @date 2023/2/9 13:18
 */
public class ArrayQueueDemo01 {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(20);
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i * 10);
        }
        int size = queue.getQueueSize();
        for (int i = 0; i < size; i++) {
            System.out.println(queue.deQueue());
        }
    }
}
