package 链表;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/19 21:00
 * @Filename Solution203
 */

// 203. 移除链表元素
// 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。

public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        // 新建一个虚拟头节点
        ListNode dummyHead = new ListNode();
        // 把虚拟头节点指向下一个节点
        dummyHead.next = head;
        // 声明一个指向虚拟头节点的指针
        ListNode cur = dummyHead;
        // 当指针没有移动到最末尾的时候
        while (cur.next != null) {
            // 找到了要删除的值
            if (cur.next.val == val) {
                // 将要删除值直接断链
                cur.next = cur.next.next;
            } else {
                // 滑动到下一个节点
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
