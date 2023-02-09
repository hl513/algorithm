package com.xxx.stack04;

/**
 * @author HeP
 * @date 2023/2/9 10:27
 */
public class DynArrayStackDemo02 {
    public static void main(String[] args) {
        DynArrayStack stack = new DynArrayStack();
        // 入栈
        for (int i = 0; i < 10; i++) {
            stack.push(i * 10);
        }
        // 出栈
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
