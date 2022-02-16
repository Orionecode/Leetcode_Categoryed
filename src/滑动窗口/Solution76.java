package 滑动窗口;

import java.util.HashMap;
import java.util.Map;

// 76. 最小覆盖子串
// 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

class Solution76 {
    HashMap<Character, Integer> dstMap = new HashMap<>();
    HashMap<Character, Integer> windowMap = new HashMap<>();

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int l = 0, r = -1; // 左指针，右指针
        int len = Integer.MAX_VALUE; // 记录每次匹配符合时子串的长度
        int ansL = -1, ansR = -1; // 答案左右指针
        // 将字符添加到目标dstMap中
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            dstMap.put(c, dstMap.getOrDefault(c, 0) + 1);
        }

        // 只要不超出右边界，就一直执行
        while (r < sLen) {
            r++;
            // 反正每次都会将指针右移，如果还没到达边界并且在dstMap中包含，就添加到windowMap中
            if (r < sLen && dstMap.containsKey(s.charAt(r))) {
                windowMap.put(s.charAt(r), windowMap.getOrDefault(s.charAt(r), 0) + 1);
            }
            // 如果已经找到了子串，并且l < r，尝试收缩左指针，凡是收缩指针我们一般都用while
            while (check() && l <= r) {
                // 当前的找到的窗口长度
                int curLen = r - l + 1;
                // 如果小于已记录的最大长度就更新len，ansL，ansR
                if (curLen < len) {
                    len = curLen;
                    ansL = l;
                    // 如果这里改变为r会有什么不同？(如果变成r的话，右边会多一位出来，因为上面我们已经完成了r++)
                    ansR = l + len;
                }
                // 如果windowMap中的左边出现了t中的字符，直接减1，然后看是否还能满足完全覆盖的要求
                if (dstMap.containsKey(s.charAt(l))) {
                    // 更新windowMap的左边-1
                    windowMap.put(s.charAt(l), windowMap.getOrDefault(s.charAt(l), 0) - 1);
                }
                // 将左指针往右移动+1
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    // 这里Check的是所有windowMap里是否已经包含了所需要的全部字符（无顺序）
    public boolean check() {
        for (Map.Entry<Character, Integer> e : dstMap.entrySet()) {
            // 只要windowMap中有一个字母的值小于了dstMap中的值说明不匹配了，返回false
            if (windowMap.getOrDefault(e.getKey(), 0) < e.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution76 s76 = new Solution76();
        System.out.println(s76.minWindow("ADOBECODEBANC", "ABC"));
    }
}

