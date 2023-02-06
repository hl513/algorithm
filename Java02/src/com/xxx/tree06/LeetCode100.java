package com.xxx.tree06;

/**
 * @author HeP
 * @date 2023/2/6 19:26
 */
public class LeetCode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
