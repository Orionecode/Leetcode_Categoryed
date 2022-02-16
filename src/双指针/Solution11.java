package 双指针;

/**
 * @Author YixiaoZeng
 * @Date 2022/1/27 15:03
 * @Filename Solution11
 */

// 11. 盛最多水的容器
// 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
public class Solution11 {
	// 两个for暴力解法，带有一点点剪枝
	public static int maxArea(int[] height) {
		int ans = 0;
		for (int i = 0; i < height.length; i++) {
			int leftH = height[i];
			for (int k = i + 1; k < height.length; k++) {
				if (k < height.length - 1 && height[k] < height[k + 1]) {
					continue;
				}
				int rightH = height[k];
				ans = Math.max((k - i) * (Math.min(rightH, leftH)), ans);
			}
		}
		return ans;
	}

	// 双指针解法，左右两个指针夹逼，哪边的指针对应的高度小就移动哪边，高度大的不变
	public static int twoPointerMaxArea(int[] height) {
		int ans = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right){
			int leftH = height[left];
			int rightH = height[right];
			ans = Math.max((right - left) * Math.min(leftH, rightH), ans);
			if (leftH <= rightH){
				++left;
			}else {
				--right;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
		System.out.println(twoPointerMaxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
	}
}
