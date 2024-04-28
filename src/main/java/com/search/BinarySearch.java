package com.search;


/*
* 二分搜索（也称为二分查找、折半查找）是一种在有序数组中查找目标值的算法。
* 它的基本思想是每次将搜索范围减半，从而大幅度减少查找的时间复杂度。
* */
public class BinarySearch {

    // 非递归实现
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) { // 当左指针小于等于右指针时
            int mid = left + (right - left) / 2; // 避免直接相加可能导致溢出

            if (arr[mid] == target) { // 找到目标值
                return mid;
            } else if (arr[mid] < target) { // 目标值在右半部分
                left = mid + 1;
            } else { // 目标值在左半部分
                right = mid - 1;
            }
        }

        return -1; // 没有找到目标值
    }

    // 递归实现
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) { // 搜索范围为空时返回-1
            return -1;
        }

        int mid = left + (right - left) / 2; // 中点

        if (arr[mid] == target) { // 找到目标值
            return mid;
        } else if (arr[mid] < target) { // 目标值在右半部分
            return binarySearchRecursive(arr, target, mid + 1, right);
        } else { // 目标值在左半部分
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        int target = 7;

        int index = binarySearch(arr, target); // 非递归实现
        if (index != -1) {
            System.out.println("目标值 " + target + " 的索引是: " + index);
        } else {
            System.out.println("目标值 " + target + " 未找到");
        }

        int recursiveIndex = binarySearchRecursive(arr, target, 0, arr.length - 1); // 递归实现
        if (recursiveIndex != -1) {
            System.out.println("目标值 " + target + " 的索引是: " + recursiveIndex);
        } else {
            System.out.println("目标值 " + target + " 未找到");
        }
    }
}

