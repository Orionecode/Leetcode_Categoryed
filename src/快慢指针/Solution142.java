package 快慢指针;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/20 13:23
 * @Filename Solution142
 */

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // 此题目与141题区别在这，由于我们要计算相遇的位置，所以将快指针也设置为头节点指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇
            if (slow == fast) {
                ListNode node1 = head;
                ListNode node2 = fast;
                while (node1 != node2) {
                    node1 = node1.next;
                    node2 = node2.next;
                }
                return node1;
            }
        }
        return null;
    }
}
