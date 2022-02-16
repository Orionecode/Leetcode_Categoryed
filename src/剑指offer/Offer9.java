package 剑指offer;

import java.util.Deque;
import java.util.LinkedList;

public class Offer9 {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public Offer9(){
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    public void appendTail(int value){
        stack1.push(value);
    }

    public int delete(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()){
            return -1;
        }else {
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        Offer9 myOffer = new Offer9();
        myOffer.appendTail(8);
        myOffer.delete();
    }
}
