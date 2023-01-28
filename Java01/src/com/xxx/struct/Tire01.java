package com.xxx.struct;

import java.util.Scanner;

/**
 * @author HeP
 * @date 2023/1/27 10:18
 * Tire树，字典树，前缀树
 */
public class Tire01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // 插入单词
    public void insert(String word) {
        TrieNode node = root;
        // 转换为字符数组
        for (char c : word.toCharArray()) {
            // 如果不为空，则存入
            if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        // 指向最后一位
        node.isWord = true;
    }


    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) return false;
            // 不为空，则继续往下走
            node = node.children[c - 'a'];
        }
        return node.isWord;
    }

    public boolean startWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return true;
    }
}

class TrieNode {
    TrieNode[] children;
    // 标记
    boolean isWord;
    public TrieNode() {
        children = new TrieNode[26];
    }
}