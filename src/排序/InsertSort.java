package 排序;

import java.util.Arrays;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/20 15:30
 * @Filename InsertSort
 */

public class InsertSort {
    public static int[] insertSort(int[] sourceArray) {
        // 对sourceArray进行拷贝
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        // 从1 开始
        for (int i = 1; i < arr.length; i++) {
            // 要插入的数
            int insert = arr[i];
            // 预计插入位置，从已经排好序的i开始
            int j = i;
            // 如果预计插入位置j的前一个数 > 插入数
            while (j > 0 && arr[j - 1] > insert) {
                // 当前数就等于前一个数
                arr[j] = arr[j - 1];
                // 再往前移
                j--;
            }
            arr[j] = insert;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertSort(new int[]{145, 14, 3, 2, 64, 35, 53, 2, 6})));
    }
}
