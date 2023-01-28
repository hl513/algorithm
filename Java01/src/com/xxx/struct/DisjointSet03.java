package com.xxx.struct;

import com.sun.deploy.ui.UIFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HeP
 * @date 2023/1/27 10:44
 * 并查集 : 树形的数据结构，用来处理不交集的合并及查询问题
 * Find: 确定元素属于哪一个子集。它可以被用来确定两个元素是否属于同一个子集
 * Union: 将两个子集合并成一个集合。
 * 优化版本 力扣 128
 */
public class DisjointSet03 {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        DSU02 dsu = new DSU02(nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) continue;
            map.put(nums[i], i);
            if (map.containsKey(nums[i] + 1)) dsu.union(i, map.get(nums[i] + 1));
            if (map.containsKey(nums[i] - 1)) dsu.union(i, map.get(nums[i] - 1));
        }
        return dsu.findMax();
    }
}

class DSU02 {
    // 创建数组来存每一个父元素
    int[] parent;
    int[] size;

    public DSU02(int N) {
        parent = new int[N];
        size = new int[N];
        // 每个位置开始都是自己
        for (int i = 0; i < N; i++) parent[i] = i;
        Arrays.fill(size, 1);
    }

    public int find(int x) {
        // 如果父元素与自己不相同
        if (parent[x] != x) parent[x] = find(parent[x]); // 将拿到的父元素保存到当前元素位置
        // 返回当前元素的父元素
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return;
        if (size[rootX] <= size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }

    public int findMax() {
        int max = 0;
        for (int s : size) max = Math.max(max, s);
        return max;
    }
}
