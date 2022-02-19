package 栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/19 11:11
 * @Filename Solution155
 */

// 155. 最小栈
//     使用两个LinkedList实现，一个保存所有的栈，另一个保栈存最小值

public class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MIN_VALUE);
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
