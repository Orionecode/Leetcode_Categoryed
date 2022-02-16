package 双指针;

import java.util.Arrays;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/12 20:17
 * @Filename Solution189
 */

// 189. 轮转数组
/*给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 **/
public class Solution189 {
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void reverse(int[] nums, int begin, int end) {
        int temp = 0;
        while (begin < end) {
            temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
