package 双指针;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/20 13:49
 * @Filename Solution125
 */
public class Solution125 {
    public static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        // 有等于，判断中间那一位，没有等于，不判断
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
