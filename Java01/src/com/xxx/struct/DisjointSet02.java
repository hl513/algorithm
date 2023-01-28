package com.xxx.struct;

/**
 * @author HeP
 * @date 2023/1/27 10:44
 * 并查集 : 树形的数据结构，用来处理不交集的合并及查询问题
 * Find: 确定元素属于哪一个子集。它可以被用来确定两个元素是否属于同一个子集
 * Union: 将两个子集合并成一个集合。
 */
public class DisjointSet02 {
    public static void main(String[] args) {

    }
}

class DSU {
    // 创建数组来存每一个父元素
    int[] parent;

    public DSU(int N) {
        parent = new int[N];
        // 每个位置开始都是自己
        for (int i = 0; i < N; i++) parent[i] = i;
    }

    public int find(int x) {
        // 如果父元素与自己不相同
        if (parent[x] != x) parent[x] = find(parent[x]); // 将拿到的父元素保存到当前元素位置
        // 返回当前元素的父元素
        return parent[x];
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}
