package com.xxx.basic.tree13;

import java.util.*;

/**
 * @author HeP
 * @date 2023/2/4 10:25
 */
public class LeetCode314 {


    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> colToNode = new HashMap<>();
        Map<TreeNode, Integer> position = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);
        int min = 0;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            int col = position.get(cur);
            colToNode.computeIfAbsent(col, x -> new ArrayList<>()).add(cur.val);
            if (cur.left != null) {
                q.add(cur.left);
                position.put(cur.left, col - 1);
            }
            if (cur.right != null) {
                q.add(cur.right);
                position.put(cur.right, col + 1);
            }
            min = Math.min(min, col);
        }
        while (colToNode.containsKey(min)) res.add(colToNode.get(min++));
        return res;
    }


}
