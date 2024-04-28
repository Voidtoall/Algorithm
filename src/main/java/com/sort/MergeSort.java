package com.sort;


/**
 *
 归并排序（Merge Sort）是一种基于分治思想的排序算法。它通过将数组不断分割成更小的子数组，
 直到每个子数组只有一个元素，
 然后将这些子数组逐步合并，最终形成一个有序数组。
 归并排序的时间复杂度是 O(n log n)，是比较高效的排序算法之一。
 */
public class MergeSort {
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // 找出中间索引
            int mid = (left + right) / 2;
            // 对左边数组进行递归
            mergeSort(array, left, mid);
            // 对右边数组进行递归
            mergeSort(array, mid + 1, right);
            // 合并
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        // 创建临时数组
        int[] temp = new int[right - left + 1];
        int i = left; // 左数组起始索引
        int j = mid + 1; // 右数组起始索引
        int k = 0; // 临时数组起始索引

        // 合并两个有序数组
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        // 将左边剩余元素填充进temp中
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        // 将右边剩余元素填充进temp中
        while (j <= right) {
            temp[k++] = array[j++];
        }

        // 将temp中的元素全部拷贝到原数组中
        for (int p = 0; p < temp.length; p++) {
            array[left + p] = temp[p];
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("排序前的数组：");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        mergeSort(array, 0, array.length - 1);

        System.out.println("排序后的数组：");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}

