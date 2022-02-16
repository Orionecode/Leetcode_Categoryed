package 创新思路;

// 31. 下一个排列

import java.util.Arrays;

/**
 * @Author YixiaoZeng
 * @Date 2022/1/27 15:50
 * @Filename Solution31
 */
public class Solution31 {
	public static void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int j = nums.length - 1;
			while (j >= 0 && nums[i] >= nums[j]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
		System.out.println(Arrays.toString(nums));
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void reverse(int[] nums, int start) {
		int left = start, right = nums.length - 1;
		while (left < right) {
			swap(nums, left, right);
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		nextPermutation(new int[]{1, 2, 3});
	}
}
