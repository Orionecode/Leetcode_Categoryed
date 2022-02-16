package 创新思路;

// 557. 反转字符串中的单词 III

public class Solution557 {
    public static String reverseWords(String s) {
        String[] temp;
        StringBuilder newString = new StringBuilder();
        String splitter = " ";
        temp = s.split(splitter);
        for (int i = 0; i < temp.length; i++){
            char[] tempArray = temp[i].toCharArray();
            int length  = tempArray.length - 1;
            for (int k = length; k >= 0; k--){
                newString.append(tempArray[k]);
            }
            if (i != temp.length - 1){
                newString.append(" ");
            }
        }
        return newString.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
