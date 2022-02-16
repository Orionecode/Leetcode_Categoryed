package 模拟;

// 6. Z 字形变换
// 方法一：按行排序
//        思路
//
//        通过从左向右迭代字符串，我们可以轻松地确定字符位于 Z 字形图案中的哪一行。

public class Solution6 {
    public static String convert(String s, int numRows) {
        if(numRows == 1)
            return s;

        int length = Math.min(s.length(), numRows);
        String []convertString = new String[length];
        for(int i = 0; i < length; i++){
            convertString[i] = "";
        }
        int line = 0;
        boolean down = false;

        // 从这里开始是关键
        for (int i = 0; i < s.length(); i++){
            convertString[line] += s.substring(i, i+1);
            // 如果行数为0往下down 行数等于最大行再次更改为False往上走
            if(line == 0 || line == numRows -1){
                //down变为True
                down = !down;
            }
            line += down ? 1 : -1;
        }

        // 遍历convertString将字符添加在一起
        String ans = "";
        for (String row : convertString){
            ans += row;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",4));
    }
}


















