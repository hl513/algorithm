package com.xxx.basic.bfs02;

import java.util.*;

/**
 * @author HeP
 * @date 2023/1/28 12:30
 */
public class LeetCode127_02 {

    public int ladderLength(String beginWord, String endWord, List<String> wordListInput) {
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        Set<String> wordList = new HashSet<>(wordListInput);
        Set<String> visited = new HashSet<>();
        if (!wordList.contains(endWord)) return 0;
        int step = 1, N = beginWord.length();
        beginSet.add(beginWord);
        endSet.add(beginWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            Set<String> nextSet = new HashSet<>();
            for (String word : beginSet) {  // 从beginSet里面的每一个word展开，看是否到达endSet
                char[] chs = word.toCharArray();
                for (int i = 0; i < N; i++)
                    for (char c = 'a'; c <= 'z'; c++) {
                        char pre = chs[i];
                        chs[i] = c;
                        String nextWord = new String(chs);
                        if (endSet.contains(nextWord)) return step + 1;
                        if (visited.add(nextWord) && wordList.contains(nextWord)) nextSet.add(nextWord);
                        chs[i] = pre;
                    }
            }
            // 最核心的优化，我们选择较小的一端进行展开
            if (endSet.size() < nextSet.size()) {
                beginSet = endSet;
                endSet = nextSet;
            } else beginSet = nextSet;
            step++;
        }
        return 0;
    }
}

