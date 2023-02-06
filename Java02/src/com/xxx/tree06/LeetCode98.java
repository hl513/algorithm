package com.xxx.tree06;

/**
 * @author HeP
 * @date 2023/2/6 19:36
 */
public class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 前序遍历
    private boolean isValidBST(TreeNode node, long left, long right) {
        if (node == null)
            return true;
        long x = node.val;
        return left < x && x < right &&
                isValidBST(node.left, left, x) &&
                isValidBST(node.right, x, right);
    }


    // 中序遍历
    private long pre = Long.MIN_VALUE;

    public boolean isValidBST02(TreeNode root) {
        if (root == null)
            return true;
        if (!isValidBST(root.left) || root.val <= pre)
            return false;
        pre = root.val;
        return isValidBST(root.right);
    }


    // 后序遍历
    public boolean isValidBST03(TreeNode root) {
        return dfs(root)[1] != Long.MAX_VALUE;
    }

    private long[] dfs(TreeNode node) {
        if (node == null)
            return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        long[] left = dfs(node.left);
        long[] right = dfs(node.right);
        long x = node.val;
        // 也可以在递归完左子树之后立刻判断，如果不是二叉搜索树，就不用递归右子树了
        if (x <= left[1] || x >= right[0])
            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        return new long[]{Math.min(left[0], x), Math.max(right[1], x)};
    }


}
