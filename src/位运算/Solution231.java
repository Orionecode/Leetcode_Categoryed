package 位运算;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/3 18:48
 * @Filename Solution231
 */

public class Solution231 {

	// 只要n是2的30次方的约数就可以判断是2的n次方，否则false
	public static boolean isPowerOfTwo(int n) {
		// 位做法(将1的二进制数左移动30位，然后在后面补上30个0)
		// 推荐，速度快
		final int BIG = 1 << 30;
		// Math做法
		// final int BIG2 = (int) Math.pow(2, 30);
		System.out.println(n & (n - 1));
		System.out.println(BIG);
		// System.out.println(BIG2);
		return n > 0 && BIG % n == 0;
	}

	// n是2对幂次方，所以n的二进制中只能包含一个1
	// 我们可以考虑使用位运算，将 nn 的二进制表示中最低位的那个 1 提取出来，再判断剩余的数值是否为 00 即可。
	// 位运算，对两个n和n - 1进行按位与&运算，如果为0就为2
	public static boolean isPowerOfTwo2(int n) {
		return n > 0 && (n & (n - 1)) == 0;
	}

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(8));
	}
}
