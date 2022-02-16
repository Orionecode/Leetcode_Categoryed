package 哈希表;

// 12. 整数转罗马数字

import java.util.LinkedHashMap;

// 贪心哈希表
// 此题目比较巧妙的一点是把特殊的几个例子放入Hash表中，并且扭转了Hash表的对应关系
// 用两个List也是不错的选择

public class Solution12 {

    public static String listIntToRoman(int num) {
        int[] digits = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuffer ans = new StringBuffer();

        for (int i = 0; i < digits.length; i++) {
            int count = num / digits[i];
            if (count != 0) {
                for (int k = 0; k < count; k++) {
                    ans.append(roman[i]);
                }
                num -= count * digits[i];
            }
        }
        return ans.toString();
    }

    public static String hashIntToRoman(int num) {
        LinkedHashMap<Integer, String> romanMap = new LinkedHashMap<>();
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        StringBuffer ans = new StringBuffer();
        for (Integer key : romanMap.keySet()) {
            int count = num / key;
            if (count != 0) {
                for (int i = 0; i < count; i++) {
                    ans.append(romanMap.get(key));
                }
                num -= count * key;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(hashIntToRoman(2560));
        System.out.println(listIntToRoman(256));
    }
}
