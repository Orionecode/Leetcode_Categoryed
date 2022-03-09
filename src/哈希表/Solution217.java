package 哈希表;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/28 15:53
 * @Filename Solution217
 */

// 217. 存在重复元素

public class Solution217 {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return set.size() < nums.length;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
    }
}
