package com.xxx.basic.line01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author HeP
 * @date 2023/1/28 10:03
 * 扫描线
 * lintCode 391 数飞机
 * 给出飞机的起飞和降落时间的列表，用序列 interval 表示. 请计算出天上同时最多有多少架飞机？
 * 力扣 252 253 会员才可以做
 */
public class Scanline01 {

    public static int countOfAirplanes(List<Interval> airplanes) {
        // 扫描线法
        List<Point> list = new ArrayList<>(airplanes.size() * 2);
        for (Interval i : airplanes) {
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, 0));
        }

        // 从小到大进行排序
        Collections.sort(list, (Point p1, Point p2) -> {
            if (p1.T == p2.T) return p1.S - p2.S;
            return p1.T - p2.T;
        });

        // 进行扫描
        int cnt = 0;
        int ans = 0;
        for (Point p : list) {
            // 起飞，。天上飞机加1
            if (p.S == 1) cnt++;
                // 否则 飞机减一
            else cnt--;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Point {
    int T;
    int S;

    public Point(int T, int S) {
        this.S = S;
        this.T = T;
    }
}