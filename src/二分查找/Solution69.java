package 二分查找;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/2 20:24
 * @Filename Solution69
 */

public class Solution69 {
	public static int mySqrt(int x) {
		int left = 0;
		int right = x;
		int res = -1;
		// 二分查找法的典型是left <= right
		while (left <= right){
			// 二分查找最好将(left + right) / 2 写成 left + (right - left) / 2
			// 防止left 和 right 在数值很大时溢出
			int mid = left + (right - left) / 2;
			// 细节要注意，不用long的话结果会溢出
			if ((long) mid * mid <= x){
				res = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return res;
	}



	public static void main(String[] args) {
		System.out.println(mySqrt(2147483647));
	}
}
