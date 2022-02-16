package 回溯算法;

import java.util.*;

/**
 * @Author YixiaoZeng
 * @Date 2022/1/27 13:32
 * @Filename Solution46
 */

// 46. 全排列
// 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

// 	此题目考虑的便是深度优先遍历加上回溯的思想
// 	回溯就是进行状态重置
// 	状态变量：
// 	1.递归到第几层Depth
// 	2.已经选了哪些数Path
// 	3.当前选择的变量是否在Path中的Used布尔数组

public class Solution46 {
	public List<List<Integer>> permute(int[] nums) {
		// 初始化返回空结果的串
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length == 0)
			return res;
		// 每个分支深度遍历产生的组合path
		Deque<Integer> path = new ArrayDeque<>();
		boolean[] used = new boolean[nums.length];
		backTrack(nums, 0, path, used, res);
		return res;
	}

	private void backTrack(int[] nums, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
		// 当前遍历的层数已经等于数组时，已经遍历完成
		if (depth == nums.length) {
			// 在 Java 中，参数传递是 值传递，对象类型变量在传参的过程中，复制的是变量的地址。
			res.add(new ArrayList<>(path));
			return;
		}
		// 通过循环来产生不同的分支
		for (int i = 0; i < nums.length; i++) {
			// 对每个分支进行深度遍历，因为每次进入时i从0开始循环，使用used数组跳过已经考虑的，避免出现重复（113，311）
			if (used[i]) {
				continue;
			}
			// 递归在之前做了什么之后要进行逆向操作
			path.addLast(nums[i]);
			used[i] = true;
			backTrack(nums, depth + 1, path, used, res);
			// 这里执行逆向操作的做法就叫做回溯
			path.removeLast();
			used[i] = false;
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		Solution46 solution = new Solution46();
		List<List<Integer>> lists = solution.permute(nums);
		System.out.println(lists);
	}
}
