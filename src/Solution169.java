import java.util.Arrays;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/6 15:55
 * @Filename Solution169
 */

public class Solution169 {
    // 排序做法
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

    // 不排序做法
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

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 3, 4}));
        System.out.println(majorityElement2(new int[]{3, 3, 4}));
    }
}
