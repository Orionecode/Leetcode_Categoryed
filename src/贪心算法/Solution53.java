package 贪心算法;

//53. 最大子数组和
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
// indexOf(int ch): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。

import java.util.Arrays;

public class Solution53 {
    // 暴力算法，速度缓慢直接超时了,因为要循环两次，所以是O(n^2)
    public static int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        for (int i = 0; i < n; i++) {
            int tempAns = 0;
            int[] tempArray = new int[n - i];
            for (int j = i; j < n; j++) {
                tempAns = tempAns + nums[j];
                tempArray[j - i] = Math.max(tempAns, nums[j]);
            }
            Arrays.sort(tempArray);
            if (tempArray[n - i - 1] > ans) {
                ans = tempArray[n - i - 1];
            }
        }
        return ans;
    }

    // 贪心算法，当前指针所指元素之前的和小于当前值，则丢弃之前的序列时间复杂度为O(n)，空间复杂度O(1)
    public static int greedyMaxSubArray(int[] nums) {
        int cur_sum = nums[0];
        int max_sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 比较当前值的大小，之前的和
            cur_sum = Math.max(nums[i], cur_sum + nums[i]);
            // 比较新的当前最大值，记录的总最大值
            max_sum = Math.max(cur_sum, max_sum);
        }
        return max_sum;
    }

    // 动态规划算法（和贪心算法类似，规划了个几把）
    public static int dynamicMaxSubArray(int[] nums) {
        // 若前一个元素>0，则将其加到当前的元素上
        int pre = 0;
        int maxAns = nums[0];
        // 找出数组中的每一个数字
        for (int num : nums) {
            //
            pre = Math.max(pre + num, num);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(greedyMaxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(dynamicMaxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
