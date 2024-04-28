package com.sort;

/**
 * 快速排序（QuickSort）是一种基于分治法的高效排序算法。它通常被认为是最快的排序算法之一，
 * 时间复杂度为 O(n log n)。快速排序的核心思想是选择一个"基准"（pivot），然后将数组划分为两部分，
 * 使得基准左侧的所有元素都小于或等于基准，基准右侧的所有元素都大于或等于基准。然后递归地对两部分继续应用快速排序。
 * */
public class QuickSort {
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        int n = array.length;
        quickSort(array, 0, n - 1);
        System.out.println("排序后的数组：");
        for (int i = 0; i < n; ++i) {
            System.out.print(array[i] + " ");
        }
    }
}

