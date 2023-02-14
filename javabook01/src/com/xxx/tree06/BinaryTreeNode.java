package com.xxx.tree06;

/**
 * @author HeP
 * @date 2023/2/10 9:48
 * 二叉树
 */
public class BinaryTreeNode {
    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }
    public BinaryTreeNode() {

    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
