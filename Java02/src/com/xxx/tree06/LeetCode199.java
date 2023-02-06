package com.xxx.tree06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeP
 * @date 2023/2/6 19:34
 */
public class LeetCode199 {

    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        // 深度等于答案的长度  添加进入
        if (depth == ans.size())
            ans.add(root.val);
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }

}
