package 回溯算法;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author YixiaoZeng
 * @Date 2022/1/29 13:01
 * @Filename Solution78
 */

// 78. 子集
// 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
// 本题目又是一道回溯的题目


public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 每个分支产生的组合
        Deque<Integer> path = new ArrayDeque<>();
        backTrack(nums, 0, path, res);
        return res;
    }

    // 此题的基本思想就是深度遍历回溯加去重，
    private void backTrack(int[] nums, int i, Deque<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int start = i; start < nums.length; start++) {
            path.addLast(nums[start]);
            backTrack(nums, start + 1, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Solution78 solution = new Solution78();
        List<List<Integer>> lists = solution.subsets(nums);
        System.out.println(lists);
    }
}
