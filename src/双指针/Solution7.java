package 双指针;

// 7. 整数反转
// 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

public class Solution7 {
    public static int reverse(int x) {
        boolean minus = false;
        if (x < 0){
            minus = true;
            x = -x;
        }
        char[] str = Integer.toString(x).toCharArray();
        int left = 0;
        int right = str.length - 1;
        while (left <= (str.length - 1) / 2){
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left ++;
            right --;
        }
        if (minus){
            try {
                return -Integer.parseInt(new String(str));
            }catch (Exception exception){
                return 0;
            }
        }else{
            try {
                return Integer.parseInt(new String(str));
            }catch (Exception exception){
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
