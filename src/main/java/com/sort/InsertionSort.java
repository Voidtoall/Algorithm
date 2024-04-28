package com.sort;

/*
* 插入排序（Insertion Sort）是一种简单且直观的排序算法，适用于小规模数据集。
* 它的核心思想是将数组分成已排序和未排序两部分，从未排序部分依次取出元素，
* 并将其插入到已排序部分的正确位置。
* */
public class InsertionSort {
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            /* 将array[0..i-1]中大于key的元素都向后移动一个位置 */
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};
        insertionSort(array);
        System.out.println("排序后的数组：");
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
    }
}

