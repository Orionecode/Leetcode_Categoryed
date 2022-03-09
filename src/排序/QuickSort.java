package 排序;

import java.util.Arrays;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/22 16:20
 * @Filename QuickSort
 */
public class QuickSort {
    public static int[] quickSort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return sort(arr, 0, arr.length - 1);
    }

    private static int[] sort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            sort(arr, left, partitionIndex - 1);
            sort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        int index = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < arr[left]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, left,index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{4, 9, 3, 7, 6, 5})));
    }
}
