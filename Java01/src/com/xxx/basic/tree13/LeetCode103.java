package com.xxx.basic.tree13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author HeP
 * @date 2023/2/4 10:19
 */
public class LeetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (res.size() % 2 == 0) level.add(cur.val);  // 奇数行从左往右
                else level.add(0, cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            res.add(level);
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder02(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, int height) {
        if (root == null) return;
        if (res.size() <= height) res.add(new ArrayList<>());
        if (height % 2 == 0) res.get(height).add(root.val);
        else res.get(height).add(0, root.val);
        dfs(root.left, res, height + 1);
        dfs(root.right, res, height + 1);
    }


}
