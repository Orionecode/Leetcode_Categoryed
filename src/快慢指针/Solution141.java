package 快慢指针;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/20 13:19
 * @Filename Solution141
 */

// 141. 环形链表（Floyd 判圈算法）
//     给你一个链表的头节点 head ，判断链表中是否有环。
//     此题目采用快慢指针法，快指针每次走两步先进入环，慢指针走一步，一定会在环内与快指针相遇

public class Solution141 {
    public boolean hasCycle(ListNode head) {
        // 因为快指针是head.next，预防head.next是空指针
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        // 快慢指针没有相遇
        while (slow != fast){
            // 如果快指针已到达末端或者即将到达末端
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
