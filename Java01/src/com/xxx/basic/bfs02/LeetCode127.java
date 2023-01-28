package com.xxx.basic.bfs02;

import java.util.*;

/**
 * @author HeP
 * @date 2023/1/28 12:30
 */
public class LeetCode127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 1, N = beginWord.length();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(endWord)) return step;
                for (int j = 0; j < N; j++) {  // 循环当前单词每一位替换
                    for (char letter = 'a'; letter <= 'z'; letter++) {  // 都可以被替换成 25 个其他字母的情况
                        StringBuilder next = new StringBuilder(cur);
                        next.setCharAt(j, letter);
                        String nextWord = next.toString();
                        if (set.contains(nextWord)) {
                            if (nextWord.equals(endWord)) return step + 1;
                            set.remove(nextWord);  // 需要从set里面拿出来，否则就循环了
                            q.offer(nextWord);
                        }
                    }
                }

            }
            step++;
        }
        return 0;
    }
}

