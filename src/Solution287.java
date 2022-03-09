/**
 * @Author YixiaoZeng
 * @Date 2022/3/8 15:52
 * @Filename Solution287
 */
public class Solution287 {
    public static int findDuplicate(int[] nums) {
        // 慢指针
        int slow = 0;
        // 快指针
        int fast = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                fast = 0;
                while (nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
