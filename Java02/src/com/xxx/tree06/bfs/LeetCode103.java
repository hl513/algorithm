package com.xxx.tree06.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author HeP
 * @date 2023/2/6 19:47
 */
public class LeetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        for (boolean even = false; !cur.isEmpty(); even = !even) {
            List<TreeNode> nxt = new ArrayList<>();
            List<Integer> vals = new ArrayList<>(cur.size()); // 容量已知
            for (TreeNode node : cur) {
                vals.add(node.val);
                if (node.left != null) nxt.add(node.left);
                if (node.right != null) nxt.add(node.right);
            }
            cur = nxt;
            if (even) Collections.reverse(vals);
            ans.add(vals);
        }
        return ans;
    }
}
