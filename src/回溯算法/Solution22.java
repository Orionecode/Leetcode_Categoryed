package 回溯算法;

import java.util.ArrayList;
import java.util.List;

// 22.括号生成
// 使用回溯我们可以只在序列仍然保持有效时才添加 '(' or ')'
// 今天是采用标准写法的一天

public class Solution22 {
	List<String> ans = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		if (n <= 0) {
			return ans;
		}
		backTraceSB(new StringBuilder(), n, n, 0);
		// backTraceStr("", n, n);
		return ans;
	}

	private void backTraceStr(String str, int left, int right) {
		if (left == 0 && right == 0) {
			ans.add(str);
			return;
		}
		if (left == right) {
			//剩余左右括号数相等，下一个只能用左括号
			backTraceStr(str + "(", left - 1, right);
		} else if (left < right) {
			//剩余左括号小于右括号，下一个可以用左括号也可以用右括号
			if (left > 0) {
				backTraceStr(str + "(", left - 1, right);
			}
			backTraceStr(str + ")", left, right - 1);
		}
	}

	public void backTraceSB(StringBuilder stringBuilder, int left, int right, int count) {
		// 如果左右括号的剩余值都为0，则将上次传递的最后一个符号加入ans
		if (left == 0 && right == 0) {
			ans.add(stringBuilder.toString());
			// 回溯的地方（回到上一次调用本方法的地方），每次添加完后StringBuilder并不会清零！！
			return;
		}
		// 如果左右括号相等，下一个只能加左括号
		if (left == right) {
			// 要注意先自增和后自增的区别
			// ++count是先加再执行语句
			// count++是先执行语句再增加，这里用count ++ 会导致错误
			backTraceSB(stringBuilder.append("("), left - 1, right, ++count);
			// 回溯操作
			count--;
			stringBuilder.deleteCharAt(count);
		} else if (left < right) {
			// 如果左括号小于右括号，则既可以加左括号，也可以加右括号
			if (left > 0) {
				backTraceSB(stringBuilder.append("("), left - 1, right, ++count);
				count--;
				stringBuilder.deleteCharAt(count);
			}
			// 回溯完成在这里，一直向上回溯直到left > 0可进入新条件分支 （最后一个一定是在这里，因为最后一个只能添加右括号）
			backTraceSB(stringBuilder.append(")"), left, right - 1, ++count);
			// 回溯操作
			count--;
			stringBuilder.deleteCharAt(count);
		}
	}

	public static void main(String[] args) {
		Solution22 solution22 = new Solution22();
		System.out.println(solution22.generateParenthesis(3));
	}
}
