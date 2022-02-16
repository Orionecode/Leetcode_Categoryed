package 双指针;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/12 20:07
 * @Filename Solution977
 */

// 977. 有序数组的平方
    /*又是一道双指针的题目
    * 可以用比较巧的方法来做
    * 因为是已经排序的整数数组
    * 所以从两头开始，大的负数和大的整数都在两端
    * 直接将左边负的数的负数和右边进行比较
    * 然后插入进入排序完成后就是有序数组的平方*/

public class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int i = right;
        while (left <= right) {
            if (-nums[left] > nums[right]) {
                res[i] = nums[left] * nums[left];
                left += 1;
            } else {
                res[i] = nums[right] * nums[right];
                right -= 1;
            }
            i--;
        }
        return res;
    }
}
