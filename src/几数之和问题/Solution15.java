package 几数之和问题;

// 15. 三数之和，此题目和第一题相似

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author YixiaoZeng
 * @Date 2022/1/26 19:53
 * @Filename Solution15
 */

// 此题目先排序，将三数只和问题变成两数只和的问题，将每次循环的第一位固定。

public class Solution15 {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		// 如果nums为空或者nums的长度小于等于2
		if (nums == null || nums.length <= 2) {
			return ans;
		}
		// 首先对List进行排序
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			// 如果判断的第一个数都大于0，那么后面无需判断了，都 > 0，直接返回答案，减少不必要的排序
			if (nums[i] > 0)
				break;
			// 因为不能包含重复三元组，所以遇到重复的使用continue掠过
			// （这里去重的原理是两个相邻的数如果相等，那么后面要找的相加数也就必然相等，所以直接掠过此循环）
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			// 选定需要后面两数相加的第一个数
			int target = -nums[i];
			// 设定指针从两侧夹逼
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				// 这里的if语句就是双指针控制块
				if (nums[left] + nums[right] == target) {
					ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
					left++;
					right--;
					// 确保不重复（如果这里指针指向有相同的相邻的数字，那么也需要跳出本次循环避免重复）
					while (left < right && nums[left] == nums[left - 1])
						left++;
					while (left < right && nums[right] == nums[right + 1])
						right--;
				} else if (nums[left] + nums[right] > target) {
					right--;
				} else {
					left++;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		for (List<Integer> outerList : threeSum(new int[]{-2,0,0,2,2})) {
			System.out.println(outerList);
		}
	}
}
