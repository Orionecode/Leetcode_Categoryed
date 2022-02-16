package 双指针;

// 9. 回文数
// 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false
// 此题先判断了一些完全不可能的条件，然后使用双指针求解

public class Solution9 {

    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        String str = String.valueOf(x);
        int strLength = str.length();
        int lp = 0;
        int rp = strLength - 1;
        if (strLength <= 1){
            return true;
        }else {
            while (lp < rp){
                if (str.charAt(lp) != str.charAt(rp)){
                    return false;
                }
                lp ++;
                rp --;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(22));
    }
}
