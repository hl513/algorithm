package com.xxx.tree06;

/**
 * @author HeP
 * @date 2023/2/6 19:32
 */
public class LeetCode110 {

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int leftH = getHeight(node.left);
        if (leftH == -1) return -1; // 提前退出，不再递归
        int rightH = getHeight(node.right);
        if (rightH == -1 || Math.abs(leftH - rightH) > 1) return -1;
        return Math.max(leftH, rightH) + 1;
    }

}
