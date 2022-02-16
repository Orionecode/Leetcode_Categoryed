package 回溯算法;

import java.util.*;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/1 15:51
 * @Filename Solution47
 */

// 47. 全排列 II
// 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

public class Solution47 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		// 初始化返回空结果的串
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length == 0)
			return res;
		// 这里和题目46 不一样，必须先排序！！！！！！
		Arrays.sort(nums);
		// 每个分支深度遍历产生的组合path
		Deque<Integer> path = new ArrayDeque<>();
		boolean[] used = new boolean[nums.length];
		backTrack(nums, 0, path, used, res);
		return res;
	}

	private void backTrack(int[] nums, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
		if (depth == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}
		// 因为-10 <= nums[i] <= 10
		// 维护一个局部变量来记录上一次深度遍历的值,这个值一定要小于-10，不然可能和List中的0重复导致第一次遍历的时候被continue
		int prev = -11;
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			// 如果当前值和上一次的值一样就跳过
			if (prev == nums[i]) {
				continue;
			}
			// 刷新变量
			prev = nums[i];
			used[i] = true;
			path.addLast(nums[i]);
			backTrack(nums, depth + 1, path, used, res);
			path.removeLast();
			used[i] = false;
		}
	}

	public static void main(String[] args) {
		int[] nums = {3, 3, 0, 3};
		Solution47 solution = new Solution47();
		List<List<Integer>> lists = solution.permuteUnique(nums);
		System.out.println(lists);
	}
}
