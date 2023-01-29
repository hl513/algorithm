package com.xxx.basic.stack06;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author HeP
 * @date 2023/1/29 21:09
 * 与1081 一样的代码
 */
public class LeetCode316 {

    public String removeDuplicateLetters(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] last = new int[128];
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < s.length(); i++) last[s.charAt(i)] = i;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (!visited.add(c)) continue;
            while (!stack.isEmpty() && c < stack.peek() && i < last[stack.peek()]) visited.remove(stack.pop());
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : stack) sb.append((char) i);
        return sb.toString();
    }

}
