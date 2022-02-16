package KMP;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/2 21:34
 * @Filename Solution28
 */

// 28. 实现 strStr()
// 暴力算法/KMP算法（对于简单难度的题目过于复杂）

public class Solution28 {

	public static int strStr(String haystack, String needle) {
		if (needle.isEmpty()){
			return 0;
		}
		int hayLen = haystack.length();
		int neeLen = needle.length();
		if (neeLen > hayLen){
			return -1;
		}
		for (int i = 0; i < hayLen; i++) {
			boolean flag = true;
			for (int j = 0; j < neeLen; j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)){
					flag = false;
					break;
				}
			}
			if (flag){
				return i;
			}
		}
		return -1;
	}

	public static int fuckStrStr(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

	public static void main(String[] args) {
		System.out.println(strStr("mississippi","issipi"));
	}
}
