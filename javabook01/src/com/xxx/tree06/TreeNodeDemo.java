package com.xxx.tree06;

import javax.print.ServiceUIFactory;

/**
 * @author HeP
 * @date 2023/2/14 10:16
 */
@SuppressWarnings("all")
public class TreeNodeDemo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(15);
        TreeNode l4 = new TreeNode(18);
        root.setFirstChild(l1);
        l1.setNextSibling(l2);
        l2.setFirstChild(l4);
        l2.setNextSibling(l3);
        System.out.println("所有结点值之和：" + findSum(root));
        System.out.println("求其他兄弟结点的个数:" + siblingsCount(root));
    }


    /**
     * 给定一棵树，设计算法来获取树的所有结点值之和
     *
     * @param root
     * @return
     */
    public static int findSum(TreeNode root) {
        if (root == null) return 0;
        return root.getData() + findSum(root.getFirstChild()) + findSum(root.getNextSibling());
    }

    /**
     * 给定通用树的一个结点，求其他兄弟结点的个数
     *
     * @param current
     * @return
     */
    public static int siblingsCount(TreeNode current) {
        int count = 0;
        while (count != 0) {
            count++;
            current = current.getNextSibling();
        }
        return count;
    }

    /**
     * 给定通用树中的一个结点，设计算法来计算该结点的孩子结点数
     * 找到第一个孩子结点，然后遍历该孩子结点的所有兄弟结点，就可求出解
     *
     * @param current
     * @return
     */
    public static int childCount(TreeNode current) {
        int count = 0;
        current = current.getFirstChild();
        while (current != null) {
            count++;
            current = current.getNextSibling();
        }
        return count;
    }



}
