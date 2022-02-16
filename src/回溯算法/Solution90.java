package 回溯算法;

import java.util.*;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/12 19:16
 * @Filename Solution90
 */

// 90. 子集 II
// 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 分支
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(nums);
        backTrack(nums, res, path, 0);
        return res;
    }

    private void backTrack(int[] nums, List<List<Integer>> res, Deque<Integer> path, int i) {
        res.add(new ArrayList<>(path));
        // 创建深度遍历回溯的分支条件
        int prev = -11;
        for (int start = i; start < nums.length; start++) {
            if (prev == nums[start]) {
                continue;
            }
            prev = nums[start];
            path.addLast(nums[start]);
            backTrack(nums, res, path, start + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Solution90 solution90 = new Solution90();
        List<List<Integer>> lists = solution90.subsetsWithDup(nums);
        System.out.println(lists);
    }
}
