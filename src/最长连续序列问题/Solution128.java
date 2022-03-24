package 最长连续序列问题;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/10 11:17
 * @Filename Solution33
 */

public class Solution128 {
    public static int longestConsecutive(int[] nums) {
        // 将所有值添加到HashSet中，去重
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        int res = 0;
        // 遍历nums数组
        for (int num : nums) {
        /*那么怎么判断是否跳过呢？由于我们要枚举的数一定是在数组中不存在前驱数 x - 1
        的，不然按照上面的分析我们会从 x - 1 开始尝试匹配，因此我们每次在哈希表中检查是否
        存在 x - 1 即能判断是否需要跳过了。*/
            if (!num_set.contains(num - 1)) {
                int curNum = num;
                int curStreak = 1;
                // 不断匹配num_set中是否有curNum + 1
                while (num_set.contains(curNum + 1)) {
                    curNum += 1;
                    // 当前最长长度 + 1
                    curStreak += 1;
                }
                res = Math.max(res, curStreak);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}