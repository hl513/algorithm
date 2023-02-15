package com.xxx.priorityqueue07;


/**
 * @author HeP
 * @date 2023/2/15 17:02
 * 最小堆：结点的值必须小于或等于其孩子结点的值
 * 最大堆：结点的值必须大于或等于其孩子结点的值
 */
@SuppressWarnings("all")
public class Heap {
    public int[] array;
    public int count;  // 堆中元素的个数
    public int capacity;  // 堆的大小
    public int heap_type;  // 最大堆或最小堆

    // 创建堆
    public Heap(int capacity, int heap_type) {
        this.heap_type = heap_type;
        this.count = 0;
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    // 结点的双亲
    public int Parent(int i) {
        if (i <= 0 || i >= this.count) return -1;
        return i - 1 / 2;
    }

    public int leftChild(int i) {
        int left = 2 * i + 1;
        if (left >= this.count) return -1;
        return left;
    }

    public int rightChild(int i) {
        int right = 2 * i + 2;
        if (right >= this.count) return -1;
        return right;
    }

    // 获取最大元素
    public int getMaximum(int i) {
        if (this.count == 0) return -1;
        return this.array[0];
    }

    // 堆化当前元素 (向下渗透)
    public void percolateDown(int i) {
        int l, r, max, temp;
        l = leftChild(i);
        r = rightChild(i);
        if (l != -1 && this.array[l] > this.array[i]) max = l;
        else max = i;
        if (r != -1 && this.array[r] > this.array[max]) max = r;
        if (max != i) {
            temp = this.array[i];
            this.array[i] = this.array[max];
            this.array[max] = temp;
        }
        percolateDown(max);
    }

    /**
     * 删除元素
     * 1、将第一个元素复制到其他变量
     * 2、将最后一个元素复制到第一个元素位置
     * 3、percolateDown(第一个元素)
     *
     * @return
     */
    public int deleteMax() {
        if (this.count == 0) return -1;
        int data = this.array[0];
        this.array[0] = this.array[this.count - 1];
        this.count--;  // 减少堆的大小
        percolateDown(0);
        return data;
    }

    /**
     * 插入元素
     * 1、堆的大小加1
     * 2、将新元素放在堆的尾部
     * 3、从下至上堆化这个元素
     *
     * @param data
     * @return
     */
    public void insert(int data) {
        int i;
        if (this.count == this.capacity) resizeHeap();
        this.count++;
        i = this.capacity - 1;
        while (i >= 0 && data > this.array[(i - 1) / 2]) {
            this.array[i] = this.array[(i - 1) / 2];
            i = i - 1 / 2;
        }
        this.array[i] = data;
    }

    /**
     * 扩容堆的大小
     */
    public void resizeHeap() {
        int[] array_old = new int[this.capacity];
        System.arraycopy(this.array, 0, array_old,0, this.count-1);
        this.array = new int[this.capacity * 2];
        if (this.array == null) return;
        for (int i = 0; i < this.capacity; i++) this.array[i] = array_old[i];
        this.capacity *= 2;
        array_old = null;
    }

    /**
     * 清空堆
     */
    public void destroyHeap() {
        this.count = 0;
        this.array = null;
    }

    /**
     * 数组建堆
     *
     * @param h
     * @param A
     * @param n
     */
    public void buildHeap(Heap h, int[] A, int n) {
        if (h == null) return;
        while (n > this.capacity) h.resizeHeap();
        for (int i = 0; i < n; i++) h.array[i] = A[i];
        this.count = n;
        for (int i = (n - 1) / 2; i >= 0; i--) h.percolateDown(i);
    }

    /**
     * 堆排序
     *
     * @param A
     * @param n
     */
    public void heapSort(int[] A, int n) {
        Heap h = new Heap(n, 0);
        int old_size, i, temp;
        buildHeap(h, A, n);
        old_size = h.count;
        for (i = n - 1; i > 0; i--) {
            temp = h.array[0]; // h.array[0]存在最大元素
            h.array[0] = h.array[h.count - 1];
            h.array[h.count-1] = temp;
            h.count--;
            h.percolateDown(i);
        }
        h.count = old_size;
    }

    /**
     * 给定一个最小堆，查找最大元素
     * @param h
     * @return
     */
    public int findMaxInMinHeap(Heap h){
        int max  =-1;
        for (int i = (h.count+1)/2; i <h.count ; i++) {
            if (h.array[i]>max) max = h.array[i];
        }
        return max;
    }

    /**
     * 给出删除最小堆中第i个元素的算法
     * @param h
     * @param i
     * @return
     */
    public int delete(Heap h,int i){
        int key;
        if (i<=-1 || i >this.capacity) System.out.println("Wrong position");
        key = h.array[i];
        h.array[i] = h.array[this.count-1];
        h.count--;
        h.percolateDown(i);
        return key;
    }


}
