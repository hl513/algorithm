package com.xxx.basic.stack06;

import java.util.Stack;

/**
 * @author HeP
 * @date 2023/1/29 21:28
 */
public class LeetCode402 {

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {  // 生成最小递增序列
            while (!stack.isEmpty() && k > 0 && c < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k-- > 0) stack.pop();  // 把最大的数字拿掉
        StringBuilder sb = new StringBuilder();  // 把开头的0都拿掉
        boolean zero = true;
        for (int val : stack) {
            if (val == '0' && zero) continue;
            else zero = false;
            sb.append(val - '0');
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
