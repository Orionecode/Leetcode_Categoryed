package 滑动窗口;

// 3. 无重复字符的最长子串
// 滑动窗口处理算法经典题目

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        // 初始化n为字符串长度，ans为答案
        int length = s.length(), ans = 0;
        // 初始化一个Hash Map，Key是字符 —— Value是存在的最后出现的坐标
        Map<Character, Integer> map = new HashMap<>();
        // 两个指针，end和start均初始化为0，end自加
        for (int start = 0, end = 0; end < length; end++) {
            // 找到字符串里面的第一个字母
            char alpha = s.charAt(end);
            //如果map中有字符，表明已经重复，子串分割结束
            if (map.containsKey(alpha)) {
                //将Start定位到出现新重复字符的位置，滑动指针，因为可能遇到重复字符如abba，所以需要判断哪个较大
//                start = Math.max(map.get(alpha) + 1, start);
                //这里必须确保左边指针不能向左边移动
                if (map.get(alpha) >= start){
                    start = map.get(alpha) + 1;
                }
            }
            ans = Math.max(ans, end - start + 1); //每次for都更新ans，判断新的分割是否是最大分割
            map.put(s.charAt(end), end); //map中找不到，将字符值和坐标放入map中
        }
        System.out.println(map);
        return ans;//返回ans
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
