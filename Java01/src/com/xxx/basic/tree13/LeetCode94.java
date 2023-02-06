package com.xxx.basic.tree13;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author HeP
 * @date 2023/2/4 9:52
 */
public class LeetCode94 {
    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                // 将根元素入栈
                stack.push(root);
                // 将根节点更新为 左子树
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val); // root
            root = root.right;
        }
        return res;
    }

    public List<Integer> inorderTraversal02(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }

        }
        return res;
    }
}
