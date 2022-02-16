package 创新思路;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// 利用栈来实现先进后出的顺序问题，利用模式匹配来解决匹配的问题
// containsKey() 方法检查 hashMap 中是否存在指定的键对应的关系。
// get() 获取指定 key 对应对 value
// 此题目主要是看最后列表是否为空，如果符号一一匹配，到最后Stack会为空

public class Solution20 {
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()){
            if (map.containsKey(c)){
                stack.add(c);
            } else {
                // 这一步比较巧妙的是首先判空了，如果栈是空的不能再删除，然后在删除的时候利用返回的栈头与c比较判断是否相等，如果相等了就直接返回false不用再继续判断
                    if (stack.isEmpty() || map.get(stack.removeLast()) != c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()()()"));
    }
}
