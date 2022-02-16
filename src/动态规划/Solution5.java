package 动态规划;

// 5. 最长回文子串
// 动态规划算法，此题目是找出句子中最长的回文

public class Solution5 {

    public static String longestPalindrome(String s) {
        int totalLength = s.length();
        // 如果字符串的长度小于2，一定是回文子串
        if (totalLength < 2){
            return s;
        }

        int maxLength = 1;
        int begin = 0;
        // 创建一个bool类型的二维数组（状态转移表格） 表示s[i..j]是否是回文串
        boolean[][] dp = new boolean[totalLength][totalLength];
        // 将所有长度为1的子串都是回文串
        for (int i = 0; i < totalLength; i++){
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 开始递推
        // 先枚举子串长度，从2开始一直到整个字符串的长度
        for (int subLength = 2; subLength <= totalLength; subLength++){
           // 设定左边界
            for (int i = 0; i < totalLength; i++){
                int j = subLength + i - 1;
                // 如果有边界越界，就推出当前的循环
                if (j >= totalLength){
                    break;
                }
                // 接下来是状态转移方程的实现过程
                // 如果首尾都不想等的话就不是回文串
                if (charArray[i] != charArray[j]){
                    dp[i][j] = false;
                } else {
                    // 首尾相同，并且子串长度小于3，一定是回文
                  if (j - i < 3){
                      dp[i][j] = true;
                  }else {
                      // 如果大于等于3了，就把左右各砍掉一个
                      dp[i][j] = dp[i + 1][j - 1];
                  }
                }

                // 只要 dp[i][subLength] == true 成立，就表示子串 s[i..subLength] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLength){
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("上海自来水来自海上"));
    }
}
