package com.xxx.basic.bfs02;

import java.util.*;

/**
 * @author HeP
 * @date 2023/1/28 13:34
 * 课程表
 */
public class leetCode207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];  // 根据边建立图，计算入度
        for (int i = 0; i < prerequisites.length; i++) {
            int end = prerequisites[i][0], start = prerequisites[i][1];
            graph.computeIfAbsent(start, x -> new ArrayList<>()).add(end);
            indegree[end]++;
        }
        Queue<Integer> q = new LinkedList<>();  // 找到有向图的入口，入度为0的电
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        int cnt = 0; // 根据拓扑排序的顺序，进行广度优先搜索
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            for (int nei : graph.getOrDefault(cur, new ArrayList<>()))
                if (--indegree[nei] == 0) q.offer(nei);
        }
        return cnt == numCourses;
    }
}
