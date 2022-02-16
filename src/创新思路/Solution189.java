package 创新思路;

// 189. 轮转数组
// 感觉主要考查对Java数组的应用和方法

import java.util.Arrays;

public class Solution189 {
    public static void rotate1(int[] nums, int k) {
//      方法一：使用额外的数组
        int length = nums.length;
        int[] newArr = new int[length];
//      利用余数的方式来放置新元素的位置，非常聪明，忘记了可以Debug一下
        for (int i = 0; i < length; ++i) {
            newArr[(i + k) % length] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, length);
//      Arraycopy的方法会把范围内的数值覆盖掉，如果目标数组长度大于原数组长度，则目标数组后面的内容不变
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate2(int[] nums, int k) {
//      方法二：数组翻转
        int length = nums.length;
    }

    public static void main(String[] args) {
        rotate1(new int[]{1, 3, 4, 5, 6, 7}, 3);
        rotate2(new int[]{1, 3, 4, 5, 6, 7}, 3);
    }
}
