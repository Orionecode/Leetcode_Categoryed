package 二分查找;

// 34. 在排序数组中查找元素的第一个和最后一个位置
// 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

import java.util.Arrays;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/1 14:38
 * @Filename Solution34
 */

public class Solution34 {
	public static int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[]{-1, -1};
		}
		int left = 0;
		while (left < nums.length - 1 && nums[left] != target) {
			left++;
		}
		if (left + 1 == nums.length && nums[left] != target) {
			return new int[]{-1, -1};
		} else {
			// 让右指针从右侧往左边逼近
			int right = nums.length - 1;
			while (nums[right] != target) {
				right--;
			}
			return new int[]{left, right};
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
	}
}
