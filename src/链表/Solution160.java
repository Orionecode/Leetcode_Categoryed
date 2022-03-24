package 链表;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/12 20:09
 * @Filename 链表.Solution160
 */
/*
160. 相交链表
给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
*/
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode zyx = headA;
        ListNode ljy = headB;
        while (zyx != ljy) {  // 若是有缘，迟早相遇
            zyx = zyx != null ? zyx.next : headB; // 当我走向终点，开始走她的路
            ljy = ljy != null ? ljy.next : headA; // 当她走向终点，开始走我的路
        }
        return zyx;
    }
}
