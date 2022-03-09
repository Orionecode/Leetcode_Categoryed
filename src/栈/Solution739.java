package 栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/20 14:03
 * @Filename 栈.Solution739
 */

// 739. 每日温度
//     给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用0 来代替。

public class Solution739 {
    // 方法1：暴力解法
    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1) {
            return new int[]{0};
        }
        int left = 0;
        int right = 0;
        int[] res = new int[temperatures.length];
        while (left != temperatures.length - 1) {
            int day = 0;
            right = left;
            while (right <= temperatures.length - 1) {
                if (temperatures[left] < temperatures[right]) {
                    res[left] = day;
                    break;
                } else {
                    right++;
                    day++;
                }
            }
            left++;
        }
        return res;
    }

    // 方法2：单调栈
    public static int[] dailyTemperatures2(int[] temperatures) {
        // 结果集
        int[] res = new int[temperatures.length];
        // 将默认值全部填充为0
        Arrays.fill(res, 0);
        // stack里的值全部保存的下标值
        Deque<Integer> stack = new ArrayDeque<>();
        // 一次for循环就可以得到所有解（注意length的问题）
        for (int i = 0; i < temperatures.length - 1; i++) {
            // 当stack里面还有数值的时候就要判断当前数值和栈顶数值的大小
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 出栈并返回下标
                int index = stack.pop();
                // 将下标添加到结果集
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 40, 50, 60})));
        System.out.println(Arrays.toString(dailyTemperatures2(new int[]{30, 40, 50, 60})));
    }
}
