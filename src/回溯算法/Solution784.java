package 回溯算法;

// 784. 字母大小写全排列
//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

import java.util.ArrayList;
import java.util.List;

/**
 * @Author YixiaoZeng
 * @Date 2022/1/29 15:16
 * @Filename Solution784
 */

public class Solution784 {
	public List<String> letterCasePermutation(String s) {
		char[] chS = s.toCharArray();
		List<String> ans = new ArrayList<>();
		backTrack(ans, chS, 0);
		return ans;
	}

	private void backTrack(List<String> ans, char[] chS, int i) {
		ans.add(new String(chS));
		for (int begin = i; begin < chS.length ; begin ++){
			if (!Character.isDigit(chS[begin])){
				char temp = chS[begin];
				chS[begin] = (char)(chS[begin] - 'a' >= 0 ? chS[begin] - 32 : chS[begin] + 32);
				backTrack(ans, chS, begin + 1);
				chS[begin] = temp;
			}
		}
	}

	public static void main(String[] args) {
		String S = "a1b2";
		Solution784 solution = new Solution784();
		List<String> lists = solution.letterCasePermutation(S);
		System.out.println(lists);
	}
}
