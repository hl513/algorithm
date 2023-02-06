package com.xxx.basic.recursion12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeP
 * @date 2023/2/3 10:32
 */
public class LeetCode472 {
    TrieNode root;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        root = new TrieNode();
        for (String word : words) addWord(word);
        for (String word : words) if (search(word, 0, 0)) res.add(word);
        return res;
    }

    private boolean search(String word, int index, int count) {
        if (index == word.length() && count > 1) return true;
        TrieNode cur = root;
        for (int i = index; i < word.length(); i++) {
            if (cur.chirdren[word.charAt(i) - 'a'] == null) return false;
            cur = cur.chirdren[word.charAt(i) - 'a'];
            if (cur.isWord && search(word, i + 1, count + 1)) return true;
        }
        return false;
    }

    private void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.chirdren[c - 'a'] == null) cur.chirdren[c - 'a'] = new TrieNode();
            cur = cur.chirdren[c - 'a'];
        }
        cur.isWord = true;
    }

}

class TrieNode {
    TrieNode[] chirdren;
    boolean isWord;

    TrieNode() {
        this.chirdren = new TrieNode[26];
    }
}


