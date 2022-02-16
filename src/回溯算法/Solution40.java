package 回溯算法;

import java.util.*;

/**
 * @Author YixiaoZeng
 * @Date 2022/1/27 19:15
 * @Filename Solution40
 */

// 40. 组合总和 II
// 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
//
// candidates中的每个数字在每个组合中只能使用一次。
//
// 注意：解集不能包含重复的组合。


// 这道题目和39.组合总和如下区别：
//
// 本题candidates 中的每个数字在每个组合中只能使用一次。
// 本题数组candidates的元素是有重复的，而39.组合总和是无重复元素的数组candidates

public class Solution40 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Deque<Integer> path = new ArrayDeque<>();
		// 区别1，需要排序
		Arrays.sort(candidates);
		backtrack(candidates, target, 0, res, path);
		return res;
	}


	private void backtrack(int[] candidates, int target, int start, List<List<Integer>> res, Deque<Integer> path) {
		if (target < 0)
			return;
		if (target == 0) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			// 区别2，判断这一步选用的数字是否和上一步相同（i > start有i == start的情况）
			if (i > start && candidates[i] == candidates[i - 1]){
				continue;
			}
			// 这里说明一下为什么不用used[]而使用start写法
			// 因为这道题目是求的组合，组合是不讲究顺序的，不讲究顺序的都用start来解决
			path.addLast(candidates[i]);
			backtrack(candidates, target - candidates[i], i + 1, res, path);
			path.removeLast();
		}
	}

	public static void main(String[] args) {
		int[] nums = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		Solution40 solution = new Solution40();
		List<List<Integer>> lists = solution.combinationSum2(nums, target);
		System.out.println(lists);
	}
}
