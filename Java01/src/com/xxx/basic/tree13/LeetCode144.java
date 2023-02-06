package com.xxx.basic.tree13;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author HeP
 * @date 2023/2/4 9:45
 */
public class LeetCode144 {

    // 前序遍历 第一种实现方法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            // 栈的顺序为先进后出，因此这里放入时 先放右再放左
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
        return res;
    }

    public List<Integer> preorderTraversal02(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return res;
    }
}
