package com.xxx.unionfind08;

/**
 * @author HeP
 * @date 2023/2/15 17:49
 * 并查集
 */
@SuppressWarnings("all")
public class DisjointSet {
    public int[] S;
    public int size;

    public void makeSet(int size) {
        S = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            S[i] = i;
        }
    }

    public int find(int x) {
        if (!(x >= 0 && x < size)) return -1;
        if (S[x] == x) return x;
        else return find(S[x]);
    }

    public void union(int root1, int root2) {
        if (find(root1) == find(root2)) return;
        if (!(root1 >= 0 && root1 < size) && (root2 >= 0 && root2 < size)) return;
        S[root1] = root2;
    }
}
