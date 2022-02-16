package 滑动窗口;

// 14. 最长公共前缀
// 遇到这种题目可以考虑子串判断，将数组中的第一个单词全部字符设置为子串，然后循环下去对子串进行一一对比

public class Solution14 {
    public static String longestCommonPrefix(String[] strs) {
//        如果是空字符串直接返回""
        if (strs.length == 0){
            return "";
        }
        // 将List的第一个单词的所有字母添加到答案公共前缀中
        String ans = strs[0];
        for (int i = 1; i < strs.length; i ++){
            int j = 0;
            // ！！！循环最长公共子串来确定，并且j必须小于当前单词的长度，否则会超出边界
            for (;j < ans.length() && j < strs[i].length(); j++){
//                System.out.println(strs[i].charAt(j));
                if (strs[i].charAt(j) != ans.charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0, j);
//            System.out.println(j);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
