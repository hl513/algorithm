package com.xxx.tree06;

/**
 * @author HeP
 * @date 2023/2/6 19:40
 */
public class LeetCode235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int x = root.val;
        if (p.val < x && q.val < x)
            return lowestCommonAncestor(root.left, p, q);
        if (p.val > x && q.val > x)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
