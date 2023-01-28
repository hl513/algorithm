package com.xxx.basic.bfs02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author HeP
 * @date 2023/1/28 13:08
 * 迷宫
 */
public class LeetCode490 {

    int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) return true;
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0], y = cur[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    y += dir[1];
                    x += dir[0];
                }
                x -= dir[0];
                y -= dir[1];
                if (!visited[x][y]) {
                    q.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }

}
