package 几数之和问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1. 两数之和

// 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
// 你可以按任意顺序返回答案。


public class Solution1 {
    // 哈希表法解决
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>(len - 1);
        for (int i = 0; i < len; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            }
            hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution!");
    }

    // 双指针二分查找思想加上利用排序和额外数组保存下标
    public static int[] twoPointersSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        ArrayList<Integer> cloneArray = new ArrayList<>();
        for (int num : nums) {
            cloneArray.add(num);
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                // 这里第二个返回值使用lastIndexOf来确保遇到相同数据时返回不一样的下标
                return new int[]{cloneArray.indexOf(nums[left]), cloneArray.lastIndexOf(nums[right])};
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        throw new IllegalArgumentException("No two sum solution!");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoPointersSum(new int[]{2, 7, 1, 15}, 3)));
    }
}
