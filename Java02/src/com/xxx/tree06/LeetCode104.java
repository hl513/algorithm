package com.xxx.tree06;


/**
 * @author HeP
 * @date 2023/2/6 19:18
 */
public class LeetCode104 {
    int ans = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth02(TreeNode root) {
        dfs(root, 0);
        return ans;
    }


    private void dfs(TreeNode node, int cnt) {
        if (node == null) return;
        ++cnt;
        ans = Math.max(ans, cnt);
        dfs(node.left, cnt);
        dfs(node.right, cnt);
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
