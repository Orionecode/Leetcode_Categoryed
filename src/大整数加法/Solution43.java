package 大整数加法;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/6 20:24
 * @Filename Solution43
 */

public class Solution43 {
    public static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int p : pos) if (!(stringBuilder.length() == 0 && p == 0)) stringBuilder.append(p);
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }
}
