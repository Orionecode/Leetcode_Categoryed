import java.util.Arrays;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/17 15:16
 * @Filename Solution215
 */
public class Solution215 {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
