package com.sort;


/*
*
选择排序（Selection Sort）是一种简单的排序算法。它通过在每一轮中选择最小或最大的元素，
* 并将其放在正确的位置，从而将整个数组排序。选择排序的时间复杂度为 O(n^2)，
* 空间复杂度为 O(1)，是一种稳定的排序算法。
* */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("原始数组:");
        printArray(arr);

        selectionSort(arr);

        System.out.println("\n排序后的数组:");
        printArray(arr);
    }

    // 选择排序函数
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换最小元素和当前元素
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // 打印数组函数
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

