package 回溯算法;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author YixiaoZeng
 * @Date 2022/1/27 16:33
 * @Filename Solution39
 */

// 39. 组合总和

// 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
// 对于给定的输入，保证和为target 的不同组合数少于 150 个。

// 本题目又是回溯，回溯算法几大特点：
// 1——都需要进行状态重置，回溯语句前做了什么，回溯后也要做什么，前后对应
// 2——回溯一般适用于有树形深度遍历结构的数据
// 3——讲究答案顺序用Used，不讲究顺序的用Start
// 组合不讲究顺序，排列讲解顺序（1，2），（2，1）对于组合来说是一样的，而对于排列来讲不一样

// int[] candidates 题目传入的所有可能值
// int target 距离目标的值，每次回溯都在变化
// List<List<Integer>> res 最终返回的包含数组的数组，只在需要时添加
// int i for遍历开始的index，保存每次开始的index值来避免重复的问题
// ArrayList<Integer> tmp_list 保存每次经过的路径值，在==0时清空


public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 结果
        List<List<Integer>> res = new ArrayList<>();
        // 临时结果
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(candidates, target, path, res, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, Deque<Integer> path, List<List<Integer>> res, int start) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 以2，3，5 三个数为例，当我们将2开头的找完后，循环会+1，从3开始找
        // 但是如果不能告诉start状态的话，start又会=0，将2添加到数组中，从而出现重复
        // 比如[3, 5]找完后去找[5, 3]
        // 创建分支
        for (int i = start; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            backtrack(candidates, target - candidates[i], path, res, i);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        Solution39 solution = new Solution39();
        List<List<Integer>> lists = solution.combinationSum(nums, target);
        System.out.println(lists);
    }
}
