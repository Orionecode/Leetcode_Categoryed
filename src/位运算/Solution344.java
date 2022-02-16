package 位运算;

// 344. 反转字符串
// 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
// 这是一个典型的双指针问题，指针从两头向中间夹逼就行，主要考虑怎么节省内存
// 节省内存使用空间复杂度O(1)的 位运算

public class Solution344 {
    public static void normalReverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void xorReverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n / 2; ++i) {
            int j = n - 1 - i;
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        normalReverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
        xorReverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }
}
