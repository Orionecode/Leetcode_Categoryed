package 二分查找;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/8 15:18
 * @Filename Solution704
 */

public class Solution704 {
	public static int search(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			// 关键在这里二分
			int mid = (high + low) / 2;
			int num = nums[mid];
			if (num == target) {
				return mid;
			} else if (num > target) {
				// 如果是目标小了，把上界缩小
				high = mid - 1;
			} else {
				// 如果是目标大了，将下界变大
				low = mid + 1;
			}
			System.out.println();
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 5));
	}

}
