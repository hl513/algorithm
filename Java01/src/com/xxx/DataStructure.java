package com.xxx;


import java.util.*;

/**
 * @author HeP
 * @date 2023/1/20 14:57
 */
public class DataStructure {
    public static void main(String[] args) {

        // Lined List
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        System.out.println("单链表");
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

        // Tree 树
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        // Tire 前缀树 或 字典树
        String word = "Hello";


        // Stack 栈 后进先出
        System.out.println("栈--------------------");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.add(3); // 1-->2-->3 入栈 1先进
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        // 队列 Queue 先进先出
        System.out.println("队列-------------------");
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 推荐 入队
        queue.offer(2);
        queue.add(3);
        System.out.println(queue.isEmpty());
        System.out.println(queue.poll());  // 出队
        System.out.println(queue.poll());
        System.out.println(queue.remove());  // 出队 推荐使用处理空时，会报错

        // 双端队列
        System.out.println("双端队列-------------------");
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(1);
        deque.addLast(2); // 1-->2
        deque.offerFirst(0); // 0-->1-->2
        System.out.println(deque.peekFirst()); // 0
        System.out.println(deque.pollFirst()); // 0
        System.out.println(deque.pollLast()); // 2

        // heap 堆 最大堆和最小堆
        // 默认最小堆
        System.out.println("堆------------------");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(2); // 推荐 O(logn)
        pq.add(0); // O(logn)
        pq.add(1);
        System.out.println(pq.peek()); // 0 O(1)
        System.out.println(pq.poll()); // 0  O(logn)
        System.out.println(pq.poll()); // 1

        // hashMap 散列表 key-value
        // 解决index冲突的方法 1、挂链表 2、开放地址法
        System.out.println("哈希表-----------------------");
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 0);
        map.put("B", 1);
        map.put("C", 2);
        System.out.println(map.get("A"));
        System.out.println(map.get("C"));
        System.out.println(map.containsKey("B"));

        // set  不允许出现重复元素  不保证集合中元素的顺序 底层是hashmap
        System.out.println("HashSet-------------------");
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set.contains(1));
        System.out.println(set.contains(2));

        // Disjoint-Set 并查集
        // Find：确定元素属于哪一个子集。它可以被用来确定两个元素是否属于同一子集
        // Union： 将两个子集合并成同一个集合

        // Graph 图


    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
    }
}

class DSU {
    int[] parent;

    public DSU(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}