package 位运算;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/3 19:43
 * @Filename Solution191
 */

public class Solution191 {
	public static int hammingWeight(int n) {
		int ret = 0;
		// 因为输入长度固定为32的二进制串
		for (int i = 0; i < 32; i++) {
			// (1 << i)就是在左移位数，然后与n进行位运算
			// 因为只有1&1才能是等于1，所以此方法可以判断输入二进制串中的汉明重量
			if ((n & (1 << i)) != 0){
				ret ++;
			}
		}
		return ret;
    }

	public static void main(String[] args) {
		System.out.println(hammingWeight(00000000000000000000000000001011));
	}
}
