package com.xxx.tree06;

/**
 * @author HeP
 * @date 2023/2/6 19:28
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSameTree(root.left, root.right);

    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        return p.val == q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
}
