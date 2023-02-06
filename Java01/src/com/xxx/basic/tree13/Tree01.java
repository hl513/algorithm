package com.xxx.basic.tree13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeP
 * @date 2023/2/4 9:33
 */
public class Tree01 {
    /**
     * 树的遍历：
     * 1、先序遍历：先输出根节点，再输出左右子树
     * 2、中序遍历：先遍历左子树，再遍历根节点，再来根节点
     * 3、后序遍历：左右根
     */

    public List<Integer> TRAVERSAL(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        proorder(root, res);
        return res;
    }

    // 前序遍历
    private void proorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);  // 根左右
        proorder(root.left, res);
        proorder(root.right, res);
    }

    // 中序遍历
    public void Inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        Inorder(root.left, res);
        res.add(root.val);  // 左根右
        Inorder(root.right, res);
    }


    // 后序遍历
    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);  // 左右根
    }

}

class TreeNode {
    TreeNode right;
    TreeNode left;
    int val;

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