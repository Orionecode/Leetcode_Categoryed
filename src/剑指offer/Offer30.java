package 剑指offer;

import java.util.LinkedList;

public class Offer30 {
    // Java中LinkedList，Stack，ArrayDeque都可以作为栈来使用
    // 但是Java中的Stack是List实现的，LinkedStack是用链表实现的
    // https://segmentfault.com/a/1190000019076869
    // https://blog.csdn.net/m0_37128231/article/details/81098818
//    !!!!!!!!!!!!!!!!!!!!!!!!!!!
//    Stack实现、与LinkedList实现的输出是不一样的。顺序刚好是相反的。
//    Stack类实现时，push和pop。都是对数组最高下标成员进行操作。从而实现后进先出（LIFO）。
//    LinkedList进行push和pop操作时，是通过对链表first节点进行操作的，得到LIFO的效果。
    LinkedList<Integer> A, B;

    /**
     * initialize your data structure here.
     */
    public Offer30() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.isEmpty() || B.peek() >= x){
            B.add(x);
        }
    }

    public void pop() {
        if(A.pop().equals(B.peek())){
            B.pop();
        }
    }

    public int top() {
        return  A.peek();
    }

    public int min() {
        return B.peek();
    }
}
