package 链表;

// 这里复用了Solution876的ListNode Class
// 19. 删除链表的倒数第 N 个结点
// 此题目中，有三种解法，优先考虑双指针法和遍历链表法，使用栈的速度太慢，占用内存大，不推荐。

import java.util.Deque;
import java.util.LinkedList;

public class Solution19 {
    public ListNode lengthRemoveNthFromEnd(ListNode head, int n) {
        // 先创建一个哑节点
        ListNode dummy = new ListNode();
        // 将哑节点指向头节点
        dummy.next = head;
        // 声明一个cur指针从哑节点
        ListNode cur = dummy;
        int length = 0;
        // 计算链表长度
        while (head != null){
            length ++;
            head = head.next;
        }
        // 将指针指向要删除的节点
        for (int i = 0; i < length - n; i ++){
            cur = cur.next;
        }
        // 删除节点
        cur.next = cur.next.next;
        return dummy.next;
    }

    public ListNode stackRemoveNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++){
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }

    public ListNode FOSRemoveNthFromEnd(ListNode head, int n) {
        // 如果是空ListNode，直接返回head
        if (head == null) {
            return head;
        }
        // 先声明两个快慢指针
        ListNode slow = head;
        ListNode fast = head;
        // 快指针遍历到要删除到位置
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        //如果遇到长度为1的输入，执行玩上一步后fast为null，所以直接返回头节点的下一个节点
        if (fast == null) {
            return head.next;
        }
        // 如果fast指针还没有到末尾，同时移动指针，slow指针会刚好停在需要删除的前一个节点
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        // 删除下一个节点
        slow.next = slow.next.next;
        return head;
    }
}
