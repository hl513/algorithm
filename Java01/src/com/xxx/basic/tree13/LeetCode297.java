package com.xxx.basic.tree13;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author HeP
 * @date 2023/2/4 10:35
 */
public class LeetCode297 {

    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(q);
    }

    private TreeNode helper(Queue<String> q) {
        String s = q.poll();
        if (s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = helper(q);
        root.right = helper(q);
        return root;
    }
}
