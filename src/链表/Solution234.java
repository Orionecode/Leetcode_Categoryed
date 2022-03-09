package 链表;

import java.util.WeakHashMap;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/22 19:46
 * @Filename Solution234
 */

// 234. 回文链表

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 当前节点
        ListNode cur = slow.next;
        slow.next = null;
        // pre：当前节点的前一个节点
        ListNode pre = null;
        while (cur != null) {
            // 保存原本的下一个节点
            ListNode temp = cur.next;
            // 将cur指向前一个
            cur.next = pre;
            // 将pre指针移动到cur的位置
            pre = cur;
            // 将指针移动到下一个节点
            cur = temp;
        }
        while (head != null && pre != null) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }
}
