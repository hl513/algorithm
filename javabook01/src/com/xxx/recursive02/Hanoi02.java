package com.xxx.recursive02;

/**
 * @author HeP
 * @date 2023/2/7 9:13
 * A B C   A-->C
 * 汉诺塔问题：不能出现 大圆盘在 小圆盘身上
 * 1、将源柱最上面的n-1个圆盘移动到辅助盘
 * 2、将第n个圆盘从源柱移动到目的柱
 * 3、将辅助柱的n-1个圆盘移动到目的柱
 */
public class Hanoi02 {

    public static void main(String[] args) {
//        hanoi(3, 'A', 'B', 'C');
        int[] nums = {1, 2, 4, 5, 6, 7};
        int[] arr = {1, 2, 3, 4, 5, 3, 2, 1};

//        System.out.println(isArrayInSortOrder(nums, nums.length - 1));
        System.out.println(isArrayInSortOrder(arr,arr.length));
    }

    // from to aux
    public static void hanoi(int n, char A, char B, char C) {
        // 只有一个盘时，直接移动
        if (n == 1) {
            System.out.println("Move disk - from peg " + A + " to peg " + B);
            return;
        }
        // 利用C柱作辅助，将A柱最上面的 n-1 个圆盘移动到 B柱
        hanoi(n - 1, A, C, B);
        // 将余下的圆盘从A柱移到C柱
        System.out.println("Move disk from peg " + A + " to peg " + B);
        // 利用A柱作辅助，将B柱上的n-1个圆盘移动到C柱
        hanoi(n - 1, C, B, A);
    }

    // 判断数组中的元素是否有序  无序才能运行，有序会报错
    public static int isArrayInSortOrder(int[] nums, int index) {
        if (nums.length == 1) return 1;
        // 当前数小于后面一个数 表示无序
        return (nums[index - 1] <= nums[index - 2]) ? 0 : isArrayInSortOrder(nums, index - 1);
    }
}
