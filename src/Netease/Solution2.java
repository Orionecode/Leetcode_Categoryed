package Netease;

import java.util.Scanner;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/27 14:39
 * @Filename Solution2
 */

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String text = in.next();
            System.out.println(resolve(text));
        }

    }
    public static int resolve (String text) {
        int length = text.length();
        int[] dp = new int[length];
        dp[0] = 0;
        for (int i = 1; i < length; i++) {
            if (Math.abs(text.charAt(i) - text.charAt(i - 1)) <= 1) {
                int cur = text.charAt(i) - 'a' + 1;
                int prv = text.charAt(i - 1) - 'a' + 1;
                dp[i] = Math.max(cur + prv, dp[i - 1]) + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[length - 1];
    }

}
