package 创新思路;

import java.util.Arrays;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/17 20:08
 * @Filename 创新思路.Solution75
 */

// 75. 颜色分类
// 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
// 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
// 必须在不使用库的sort函数的情况下解决这个问题。

// 这道题目我的想法是将所有的0移动到左边，所有的2移动到右边
// 但是需要注意的是，移动的过程中必须进行交换，并且因为i是边界条件，

public class Solution75 {
    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // i是作为边界指针用的，一旦i == right就证明已经移动完成了
        int i = 0;
        // 最难想到的就是为什么i<=right 因为移动完后i>right会造成将最后一部分已经完成移动2重新替换掉
        while (i <= right) {
            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
                i ++;
            } else if (nums[i] == 2) {
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }
}
