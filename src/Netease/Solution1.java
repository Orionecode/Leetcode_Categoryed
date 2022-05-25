package Netease;

import java.util.Scanner;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/27 14:39
 * @Filename Solution1
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println(resolve(a,b,x,y));
        }
    }
    public static int resolve (int a, int b, int x, int y) {
        int count = 0;
        if (y * 2 >= x) {
            while (a >= 0 || b >= 0){
                if (a > 0){
                    a -= y;
                }
                if (b > 0){
                    b -= y;
                }
                count ++;
            }
        } else {
            while (a > 0){
                a -= x;
                count ++;
            }
            while (b > 0){
                b -= x;
                count ++;
            }
        }
        return count;
    }
}
