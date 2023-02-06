package com.xxx.basic.recursion12;


/**
 * @author HeP
 * @date 2023/2/3 10:15
 */
public class LeetCode968 {

    int res = 0;

    public int minCameraCover(TreeNode root) {
        return (dfs(root) < 1 ? 1 : 0) + res;

    }
    private int dfs(TreeNode root) {
        if (root == null) return 2;
        int left = dfs(root.left), right = dfs(root.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        if (left == 1 || right == 1) return 2;
        if (left == 2 && right == 2) return 0;
        return 1000000;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
