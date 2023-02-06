package com.xxx.basic.tree13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author HeP
 * @date 2023/2/4 10:05
 */
public class LeetCode102 {
    // 层序遍历第一种解法
    public List<List<Integer>> levelOrder(TreeNode root) {
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


    // bfs
    public List<List<Integer>> levelOrder02(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                level.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            res.add(level);
        }
        return res;
    }

    // res旧指针方法
    public List<TreeNode> levelOrder03(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        int slow = 0;
        res.add(root);
        while (slow < res.size()) {
            TreeNode cur = res.get(slow++);
            if (cur.left != null) res.add(cur.left);
            if (cur.right != null) res.add(cur.right);
        }
        return res;
    }

}
