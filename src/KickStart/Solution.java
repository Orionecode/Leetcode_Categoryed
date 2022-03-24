package KickStart;

import java.util.Scanner;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/20 15:38
 * @Filename Solution
 */

public class Solution {
    private static void runCase(int i, int num) {
        int len = (num + "").length();
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= len; j++) {
            int times = (int) Math.pow(10, j);
            int a = num / times;
            for (int k = 0; k < 10; k++) {
                int res = (a * 10 + k) * times + (num - (a * times));
                if (res % 9 == 0) {
                    if (res > num && res < ans)
                        ans = res;
                }
            }
        }
        System.out.println("Case #" + (i + 1) + ": " + ans);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        for (int i = 0; i < a; i++) {
            int num = input.nextInt();
            runCase(i, num);
        }
    }
}
