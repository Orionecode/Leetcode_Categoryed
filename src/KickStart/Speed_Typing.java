package KickStart;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/20 12:13
 * @Filename Speed_Typing
 */

public class Speed_Typing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        for (int i = 0; i < a; i++) {
            String I = input.next();
            String P = input.next();
            runCase(i, I, P);
        }
    }

    private static void runCase(int num, String I, String P) {
        int count = 0;
        Deque<Character> deque1 = new ArrayDeque<>();
        Deque<Character> deque2 = new ArrayDeque<>();
        for (int i = 0; i < I.length(); i++) {
            deque1.addLast(I.charAt(i));
        }
        for (int i = 0; i < P.length(); i++) {
            deque2.addLast(P.charAt(i));
        }
        while (!deque2.isEmpty()) {
            char a = deque1.isEmpty() ? ' ' : deque1.getLast();
            char b = deque2.getLast();
            if (a == b) {
                deque1.removeLast();
                deque2.removeLast();
            } else {
                deque2.removeLast();
                count++;
            }
        }
        if (deque1.isEmpty()) {
            System.out.println("Case #" + (num + 1) + ": " + count);
        } else {
            System.out.println("Case #" + (num + 1) + ": IMPOSSIBLE");
        }
    }
}
