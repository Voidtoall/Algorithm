package com.sort;

/*
*
冒泡排序（Bubble Sort）是一种简单的排序算法。它通过比较相邻的元素，并根据大小交换它们的顺序，
* 以将较大的元素逐渐"冒泡"到数组的末端。这个过程会重复多次，直到整个数组排序完成。
* */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("原始数组:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("\n排序后的数组:");
        printArray(arr);
    }

    // 冒泡排序函数
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // 交换相邻元素
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
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

