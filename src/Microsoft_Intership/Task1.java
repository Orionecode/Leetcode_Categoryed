package Microsoft_Intership;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/26 17:11
 * @Filename Task1
 */

public class Task1 {
    public static int solution(String S) {
        // write your code in Java SE 8
        // 先处理边界条件，只有一个的时候返回1
        if (S.length() == 1) {
            return 1;
        }
        // 声明两个数组，一个保存所有字符，另一个保存是否可以移动的状态
        List<Character> newS = new ArrayList<>();
        List<Boolean> memory = new ArrayList<>();
        // 添加所有字符到newS
        for (int i = 0; i < S.length(); i++) {
            newS.add(S.charAt(i));
        }
        // 左右箭头的指针
        int pointer = 0;
        // 当前数值的指针
        int cur = 0;
        // 结果
        int res = 0;
        while (cur < newS.size()) {
            // 上下的情况
            if (newS.get(cur) == '^') {
                memory.add(true);
                cur++;
            } else if (newS.get(cur) == 'v') {
                memory.add(true);
                cur++;
            } else if (newS.get(cur) == '<') {
                // 指向左边的情况
                if (cur == 0) {
                    memory.add(true);
                } else {
                    pointer = cur - 1;
                    if (!memory.get(pointer)) {
                        memory.add(false);
                    } else {
                        memory.add(true);
                    }
                }
                cur++;
            } else if (newS.get(cur) == '>') {
                // 指向右边的情况
                if (cur == newS.size() - 1) {
                    memory.add(true);
                } else {
                    pointer = cur + 1;
                    if (newS.get(pointer) == '>') {
                        memory.add(false);
                    } else if (newS.get(pointer) == '<') {
                        memory.add(false);
                    } else {
                        memory.add(true);
                    }
                }
                cur++;
            }
        }
        // 从保存的移动状态中计算结果
        for (Boolean m : memory) {
            if (m) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution("<<^<v>>"));
    }
}
