package com.xxx.basic.dfs03;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author HeP
 * @date 2023/1/29 9:06
 */
public class LeetCode94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                // 将根节点入栈
                stack.push(root);
                // 更新根节点为 左节点
                root = root.left;
            }
            // 然后出栈根节点
            root = stack.pop();
            // 将值添加到集合中
            res.add(root.val);
            // 最后更新为右节点
            root = root.right;
        }
        return res;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
