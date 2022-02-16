package 创新思路;

import java.util.Arrays;

// 66. 加一
// 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

/**
 * @Author YixiaoZeng
 * @Date 2022/2/1 13:11
 * @Filename Solution66
 */

public class Solution66 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[]{9})));
	}

	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			System.out.println(i);
			digits[i] += 1;
			if (digits[i] == 10){
				digits[i] = 0;
			} else {
				return digits;
			}
		}
		// 上面的情况都考虑到了，如果执行到下方代码就表明全部为0，所以要添加一位
		// 这里巧妙的利用了新数组全部为 0 的特点，将首位赋值为 1 即是答案
		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}
}
