package 哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/17 19:31
 * @Filename 哈希表.Solution49
 */

// 49. 字母异位词分组
// 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。

// 异位词排序后是相同的，可以作为键，把原序词作为值存储在列表中。

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        for (String str : strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            if (!res.containsKey(String.valueOf(chs))){
                res.put(String.valueOf(chs), new ArrayList<>());
            }
            res.get(String.valueOf(chs)).add(str);
        }
        // 这一步将values传递给ArrayList进一步包装
        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        String[] str = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution49.groupAnagrams(str));
    }
}
