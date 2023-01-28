package com.xxx.struct;

import java.io.*;
import java.util.Arrays;


/**
 * @author HeP
 * @date 2023/1/27 13:03
 * 比较器
 */
public class Comparator06 {
    static int m, n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] st = br.readLine().split(" ");
        m = Integer.parseInt(st[0]);
        int[] a = new int[m];
        for (int i = 0; i < m; i++) a[i] = i + 1;
        n = Integer.parseInt(st[1]);
        // n次询问
        while (n-- > 0) {
            String[] s = br.readLine().split(" ");
            int p = Integer.parseInt(s[0]);
            int q = Integer.parseInt(s[1]);
            // 降序排序 将a[0]~a[q-1] 进行倒序
            if (p == 0) {
                quickSort(a, 0, q - 1);
                // 升序排序 a[q]~a[m]
            } else if (p == 1) {
                Arrays.sort(a, q - 1, a.length);
            }
        }
        for (int i : a) pr.print(i+" ");

        pr.flush();
    }

    public static void quickSort(int[] q, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l - 1, j = r + 1;
        int base = q[l + r >> 1];
        while (i < j) {
            do i++; while (q[i] > base);
            do j--; while (q[j] < base);
            if (i < j) {
                int tmp = q[i];
                q[i] = q[j];
                q[j] = tmp;
            }
        }
        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }
}




