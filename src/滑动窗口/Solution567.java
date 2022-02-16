package 滑动窗口;

// 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
// 因为只考虑s1 是否是 s2的子串，所以只用统计两个字符串出现的频率即可
// 非常典型当滑动窗口题目

import java.util.Arrays;

public class Solution567 {
	public static boolean checkInclusion(String s1, String s2) {
		int n = s1.length(), m = s2.length();
		if (n > m) {
			return false;
		}
		int[] cnt1 = new int[26];
		int[] cnt2 = new int[26];
		for (int i = 0; i < n; ++i) {
			++cnt1[s1.charAt(i) - 'a'];
			++cnt2[s2.charAt(i) - 'a'];
		}
		if (Arrays.equals(cnt1, cnt2)) {
			return true;
		}
		for (int i = n; i < m; ++i) {
			++cnt2[s2.charAt(i) - 'a'];
			--cnt2[s2.charAt(i - n) - 'a'];
			if (Arrays.equals(cnt1, cnt2)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidboaoo"));
	}
}
