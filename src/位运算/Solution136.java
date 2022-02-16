package 位运算;

// 136. 只出现一次的数字
// 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution136 {
    public static int hashSingleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> e : hashMap.entrySet()) {
            if (e.getValue() == 1) {
                ans = e.getKey();
            }
        }

        // 出于某些莫名其妙的原因，这种写法速度更慢，消耗内存更大
//        for (Integer i : hashMap.keySet()) {
//            Integer count = hashMap.get(i);
//            if (count == 1) {
//                return i;
//            }
//        }
        return ans;
    }

    public static int setSingleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        // 使用迭代器
        if (set.iterator().hasNext()) {
            return set.iterator().next();
        }
        return -1;
    }

    // 一般遇到O(1)的空间复杂度可以考虑异或运算
    // 任何数和 0 做异或运算，结果仍然是原来的数
    // 任何数和其自身做异或运算，结果是 0

    // 两个操作数的位中，相同则结果为0，不同则结果为1
    // 如果有一个字母落单了，异或运算完成后的值为落单的值，如果每个数字都出现了两次，那么最后的结果为0

    public static int XORSingleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        System.out.println(hashSingleNumber(new int[]{4, 1, 2, 1, 2}));
        // System.out.println(setSingleNumber(new int[]{4, 1, 2, 1, 2}));
        // System.out.println(XORSingleNumber(new int[]{4, 1, 2, 1, 2, 4}));
    }
}
