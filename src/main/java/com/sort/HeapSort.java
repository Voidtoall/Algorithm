package com.sort;

/**
 * 堆排序（Heap Sort）是一种基于堆（Heap）的排序算法。堆是一种特殊的树形数据结构，
 * 通常使用数组来实现。堆排序利用堆的性质，将数据排序。主要步骤包括构建堆、
 * 调整堆、逐一取出堆顶元素来形成排序。
 * */
public class HeapSort {
    public void heapSort(int[] array) {
        int n = array.length;

        // 构建最大堆（Heapify）
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // 逐步提取最大元素并进行堆调整
        for (int i = n - 1; i > 0; i--) {
            // 交换根节点（最大值）与当前末尾元素
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // 对剩余元素进行堆调整
            heapify(array, i, 0);
        }
    }

    void heapify(int[] array, int n, int i) {
        int largest = i; // 初始化最大元素索引为根节点索引
        int left = 2 * i + 1; // 左子节点索引
        int right = 2 * i + 2; // 右子节点索引

        // 判断左子节点是否大于根节点
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // 判断右子节点是否大于当前最大节点
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // 如果最大值不是根节点，进行交换并递归调整
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, n, largest);
        }
    }

    public static void main(String args[]) {
        int[] array = {12, 11, 13, 5, 6, 7};
        int n = array.length;

        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(array);

        System.out.println("排序后的数组：");
        for (int i = 0; i < n; ++i) {
            System.out.print(array[i] + " ");
        }
    }
}

