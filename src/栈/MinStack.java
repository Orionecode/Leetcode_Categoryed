package 栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/19 11:11
 * @Filename Solution155
 */

// 155. 最小栈
//     使用两个LinkedList实现，一个保存所有的栈，
//     另一个保栈存最小值

public class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    // 我们只需要设计一个数据结构，使得每个元素 a 与其相应的最小值 m 时刻保持一一对应。
    // 因此我们可以使用一个辅助栈，与元素栈同步插入与删除，用于存储与每个元素对应的最小值。

    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        // 注意这里放入的是最大值
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
