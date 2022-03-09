package 摩尔投票法;

import java.util.Arrays;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/6 15:55
 * @Filename 摩尔投票法.Solution169
 */

/*169. 多数元素
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。*/

public class Solution169 {
    // 排序做法加上计算法
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        // 将count设置为1 有助于题解
        int count = 1;
        int value = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != value) {
                count = 1;
                value = nums[i];
            }
            if (nums[i] == nums[i - 1]) {
                count++;
            }
            if (count > nums.length / 2) {
                break;
            }
        }
        return value;
    }

    // 摩尔投票法
    // 遇到相同的数就投一票，遇到不同的数就减一票，最后还有票的就是众数
    public static int majorityElement2(int[] nums) {
        int count = 1;
        int value = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == value) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    value = nums[i + 1];
                }
            }
        }
        return value;
    }

    // 排序+众数特性法
    // 由于众数出现的频率大于n/2,所以在排序之后众数必存在于下标[n/2]处(本题默认数组中是一定存在众数的，所以返回下标[n/2]可行)
    public static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 3, 4}));
        System.out.println(majorityElement2(new int[]{3, 3, 4}));
    }
}
