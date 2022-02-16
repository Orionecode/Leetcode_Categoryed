package 模拟;

// 13. 罗马数字转整数（Day3 12. 整数转罗马数字）
// 经典模拟题目，要先寻找规律，罗马数字中，大数在左，小数在右表示加法，比如VI=V+I=5+1=6，
// 回到提问中的案例就是LXXX=L+X+X+X=50+10+10+10=80
// 小数在左，大数在右表示减法，比如IV=V-I=5-1=4，提问中的CM=M-C=1000-100=900
// 有一种更简单的方式让罗马数字从右往左读

import java.util.HashMap;

public class Solution13 {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int valueFirst = romanMap.get(s.charAt(i));
            // 这里是关键，两个条件必须同时满足，也就是i < n - 1
            // Java当中"&"会判断两个条件是否都是否才结束，而"&&"如果前面的条件为否，那么后面不会进行判断
            // 如果没有i < n - 1 会超出边界
            if (i < n - 1 & valueFirst < romanMap.get(s.charAt(i + 1))) {
                ans -= valueFirst;
            } else {
                ans += valueFirst;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
}
