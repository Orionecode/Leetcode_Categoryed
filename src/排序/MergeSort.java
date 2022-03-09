package 排序;

import java.util.Arrays;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/20 15:53
 * @Filename MergeSort
 */

// 平均时间复杂度：O(n log n) 空间复杂度：O(n) 稳定性：稳定，
// 归并排序最好最坏都是O(n log n)，唯一缺点是比较费空间，因为要进行拆分后递归

// 归并排序（英语：Merge sort，或mergesort），是创建在归并操作上的一种有效的排序算法，效率为（大O符号）。
//         1945年由约翰·冯·诺伊曼首次提出。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用，且各层分治递归可以同时进行。

public class MergeSort {
    public static int[] mergeSort(int[] sourceArray) {
        // 对sourceArray进行拷贝
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        // 如果数组长度小于2无需排序
        if (arr.length < 2) {
            return arr;
        }
        // 将数组二分
        int middle = arr.length / 2;
        // copy左边部分
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        // copy右边部分
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        // 开始递归
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        // 结果集
        int[] res = new int[left.length + right.length];
        int i = 0;
        // 分治思想
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                res[i] = left[0];
                i++;
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                res[i] = right[0];
                i++;
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length > 0) {
            res[i] = left[0];
            i++;
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            res[i] = right[0];
            i++;
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{4,9,3,7,6,5})));
    }
}
