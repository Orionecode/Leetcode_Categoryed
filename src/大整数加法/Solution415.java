package 大整数加法;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/6 21:16
 * @Filename Solution415
 */

// 415. 字符串相加
// 考查的就是大整数加法
// 字符串加法、链表加法以及二进制加法之类的都可以这么写

public class Solution415 {
    public static String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        // 计算要进的位数
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        // 只要3个条件还有一个为真
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                // carry += Integer.parseInt(String.valueOf(num1.charAt(i--)));
                // 用位运算更快
                carry += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                // carry += Integer.parseInt(String.valueOf(num2.charAt(j--)));
                carry += num2.charAt(j--) - '0';
            }
            // 只保留个位
            stringBuilder.append(carry % 10);
            // 要进的位数
            carry /= 10;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("123", "4890"));
    }
}
