package com.search;

/*
*线性搜索（也称为顺序搜索）是一种基本的搜索算法，适用于在无序或有序的列表中查找元素。
* 该算法从列表的头部开始，逐个检查每个元素，直到找到目标元素或到达列表末尾。
* 它的时间复杂度是 O(n)，其中 n 是列表的大小。
* */
public class LinearSearch {
    // 线性搜索方法
    public static int linearSearch(int[] array, int target) {
        // 遍历数组
        for (int i = 0; i < array.length; i++) {
            // 如果找到目标元素，返回其索引
            if (array[i] == target) {
                return i;
            }
        }
        // 如果找不到目标元素，返回 -1
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 3, 7, 2, 8, 1, 9}; // 示例数组
        int target = 7; // 要查找的目标元素

        int index = linearSearch(numbers, target); // 进行线性搜索

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}

