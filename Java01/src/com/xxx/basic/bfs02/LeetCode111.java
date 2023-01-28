package com.xxx.basic.bfs02;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author HeP
 * @date 2023/1/28 11:55
 * 二叉树的最小深度
 */
public class LeetCode111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 1;
        // 核心数据结构
        Queue<TreeNode> q = new LinkedList<>();
        // 将起点加入队列
        q.offer(root);
        while (!q.isEmpty()) {
            // 拿到当前层数，并将当前层数全部遍历
            int size = q.size();
            // 将当前队列中的所有节点向四周扩散
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) return depth;  // 都为空，直接返回结果即可
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            // 深度加1
            depth++;
        }
        return depth;
    }

    public int minDepth02(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth02(root.right) + 1;
        if (root.right == null) return minDepth02(root.left) + 1;
        return Math.min(minDepth02(root.right), minDepth02(root.left)) + 1;

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

