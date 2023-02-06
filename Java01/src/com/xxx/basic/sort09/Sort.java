package com.xxx.basic.sort09;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * @author HeP
 * @date 2023/1/30 19:56
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
//        bubbleSort(arr);

//        selectSort(arr);

//        insertSort(arr);

//        shellSort(arr);

//        quickSort(arr);
//        quickSort02(arr, 0, arr.length - 1);

        mergesort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    // 选择排序
    public static int[] selectSort(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    // 插入排序
    public static void insertSort(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int tmp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > tmp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = tmp;
        }
    }

    // 希尔排序
    public static void shellSort(int[] nums) {
        int N = nums.length;
        for (int gap = N / 2; gap > 0; gap /= 2)
            for (int i = gap; i < N; i++) {
                int tmp = nums[i];
                int j = i;
                while (nums[j - gap] > tmp) {
                    nums[j] = nums[j - gap];
                    j -= gap;
                }
                nums[j] = tmp;
            }
    }


    // 快速排序
    public static int[] quickSort(int[] nums) {
        helper(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort02(int[] q, int l, int r) {
        if (l >= r) return;
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
        quickSort02(q, l, j);
        quickSort02(q, j + 1, r);
    }

    // 归并排序
    public static void mergesort(int[] q, int l, int r) {
        int[] res = new int[q.length];
        if (l >= r) return;
        int mid = (l + r) >> 1;
        mergesort(q, l, mid);
        mergesort(q, mid + 1, r);
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) {
                res[k++] = q[i++];
            } else {
                res[k++] = q[j++];
            }
        }
        while (i <= mid) {
            res[k++] = q[i++];
        }
        while (j <= r) {
            res[k++] = q[j++];
        }

        for (i = l, j = 0; i <= r; i++, j++) {
            q[i] = res[j];
        }
    }

    private static void helper(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivot = partition(nums, left, right);
        helper(nums, left, pivot - 1);
        helper(nums, pivot + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int start = left, end = right - 1;
        while (start <= end) {
            if (nums[start] <= pivot) start++;
            else if (nums[end] > pivot) end--;
            else swap(nums, start++, end--);
        }
        swap(nums, start, right);
        return start;
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }


}
