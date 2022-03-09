import java.util.ArrayList;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/9 13:48
 * @Filename Solution383
 */

// 383. 赎金信
// 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
// 如果可以，返回 true ；否则返回 false 。
// magazine 中的每个字符只能在 ransomNote 中使用一次。

public class Solution383 {
    // 动态数组方法
    public static boolean canConstruct(String ransomNote, String magazine) {
        ArrayList<Character> mag = new ArrayList<>();
        for (int i = 0; i < magazine.length(); i++) {
            mag.add(magazine.charAt(i));
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (mag.contains(ransomNote.charAt(i))) {
                mag.remove(Character.valueOf(ransomNote.charAt(i)));
            } else {
                return false;
            }
        }
        return true;
    }

    // 静态数组方法，只能是小写
    public static boolean canConstruct2(String ransomNote, String magazine) {
        int[] mag = new int[26];
        int temp;
        // 计算字符串出现的次数
        for (int i = 0; i < magazine.length(); i++) {
            // 计算magazine距离a的距离
            temp = magazine.charAt(i) - 'a';
            // 分别放入对应的0-25号下标的数组中
            mag[temp]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            // 计算ransomNote距离a的距离
            temp = ransomNote.charAt(i) - 'a';
            // 如果有剩余，就减去
            if (mag[temp] > 0) {
                mag[temp]--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct2("aa", "ab"));
    }
}
