package 回溯算法;

import java.util.*;

/**
 * @Author YixiaoZeng
 * @Date 2022/1/29 11:56
 * @Filename Solution77
 */

// 77. 组合
// 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。(用begin)
// Java别用Stack，用ArrayDeque或者List替代，Stack is painfully slow!!!

public class Solution77 {
    // public List<List<Integer>> combine(int n, int k) {
    // 	// n为数组的长度（宽度），k为往下深度遍历的深度（也就是depth）
    // 	List<List<Integer>> res = new ArrayList<>();
    // 	// 每个分支产生的组合
    // 	Deque<Integer> path = new ArrayDeque<>();
    // 	int[] nums = new int[n];
    // 	for (int i = 0; i < n; i++) {
    // 		nums[i] = i + 1;
    // 	}
    // 	backTrack(nums, n, k, path, 0, 0, res);
    // 	return res;
    // }
    //
    // private void backTrack(int[] nums, int n, int k, Deque<Integer> path, int i, int depth, List<List<Integer>> res) {
    // 	if (depth == k) {
    // 		res.add(new ArrayList<>(path));
    // 		return;
    // 	}
    // 	for (int start = i; start < n; start++) {
    // 		path.addLast(nums[start]);
    // 		// 在这里每次对Start加上1，就可以保证下一次进入时跟自己相同的数字不会被选入
    // 		backTrack(nums, n, k, path, start + 1, depth + 1, res);
    // 		path.removeLast();
    // 	}
    // }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        backTrack(nums, res, path, 0, 0, n, k);
        return res;
    }

    private void backTrack(int[] nums, List<List<Integer>> res, Deque<Integer> path, int start, int depth, int n, int k) {
        if (depth == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < n; i++) {
            path.addLast(nums[i]);
            backTrack(nums, res, path, i + 1, depth + 1, n, k);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        Solution77 solution = new Solution77();
        List<List<Integer>> lists = solution.combine(4, 2);
        System.out.println(lists);
    }
}
