package com.xxx.tree06;

/**
 * @author HeP
 * @date 2023/2/14 10:15
 * 通用树
 */
public class TreeNode{
    private int data;
    public  TreeNode firstChild;
    public TreeNode nextSibling;

    public TreeNode(int data){
        this.data  =data;
    }
    public TreeNode(){

    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(TreeNode firstChild) {
        this.firstChild = firstChild;
    }

    public TreeNode getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(TreeNode nextSibling) {
        this.nextSibling = nextSibling;
    }
}
