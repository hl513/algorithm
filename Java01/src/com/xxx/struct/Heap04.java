package com.xxx.struct;

import java.io.*;

/**
 * @author HeP
 * @date 2023/1/27 11:14
 * 堆:
 */
public class Heap04 {
    static int N = 100010;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
    static int[] heap = new int[N];
    static int size = 0; // 堆中元素的数量

    public static void swap(int x, int y) {
        int tmp = heap[x];
        heap[x] = heap[y];
        heap[y] = tmp;
    }

    public static void down(int u) {
        int t = u;
        if (u * 2 <= size && heap[u * 2] < heap[t]) t = u * 2;
        if (u * 2 + 1 <= size && heap[u * 2 + 1] < heap[t]) t = u * 2 + 1;
        if (u != t) {
            swap(u, t);
            down(t);
        }
    }

    public static void main(String[] args) throws IOException {
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        size = n;
        String[] str = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            heap[i] = Integer.parseInt(str[i - 1]);
        }
        for (int i = n / 2; i != 0; --i) {
            down(i);
        }
        while (m-- > 0) {
            pr.write(heap[1] + " ");
            heap[1] = heap[size];
            size--;
            down(1);
        }
        pr.flush();
        pr.close();
        br.close();
    }
}