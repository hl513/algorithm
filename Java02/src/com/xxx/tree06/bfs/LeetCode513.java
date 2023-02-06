package com.xxx.tree06.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author HeP
 * @date 2023/2/6 19:48
 */
public class LeetCode513 {

    public int findBottomLeftValue(TreeNode root) {
        TreeNode node = root;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            node = q.poll();
            if (node.right != null) q.add(node.right);
            if (node.left != null) q.add(node.left);
        }
        return node.val;
    }
}
