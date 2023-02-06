package com.xxx.basic.tree13;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author HeP
 * @date 2023/2/4 9:57
 */
public class LeetCode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(0, root.val);
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }
        return res;
    }

    public List<Integer> postorderTraversal02(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> resStack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                resStack.push(cur);
                stack.push(cur);
                cur = cur.right;
            } else {
                cur = stack.pop();
                cur = cur.left;
            }
        }
        while (!resStack.isEmpty()) res.add(resStack.pop().val);
        return res;
    }
}
