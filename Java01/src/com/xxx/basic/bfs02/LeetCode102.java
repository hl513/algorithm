package com.xxx.basic.bfs02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author HeP
 * @date 2023/1/28 12:18
 * TreeNode用的 111中的
 */
public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 基础模板
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                level.add(cur.val);
                // 将同层次的左右节点都加入 队列中
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            res.add(level);
        }
        return res;
    }

    public List<List<Integer>> levelOrder02(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, int height) {
        if (root == null) return;
        if (height >= res.size()) res.add(new ArrayList<Integer>());
        res.get(height).add(root.val);
        if (root.left != null) dfs(root.left, res, height + 1);
        if (root.right != null) dfs(root.right, res, height + 1);
    }
}


