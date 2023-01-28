package com.xxx.basic.line01;

import java.util.Arrays;

/**
 * @author HeP
 * @date 2023/1/28 10:41
 */
public class LeetCode253 {

    public static int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length], ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int room = 0, end = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[end]) room++;
            else end++;
        }
        return room;
    }
}


