package 链表;

/**
 * @Author YixiaoZeng
 * @Date 2022/1/29 15:36
 * @Filename Solution206
 */

// 206. 反转链表
// 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 链表是这个样子滴 1->2->3->4->5，
// 我们只需要改变链表所有节点指向的方向就可以反转链表
/*
       第一轮出栈，head为5，head.next为空，返回5
       第二轮出栈，head为4，head.next为5，执行head.next.next=head也就是5.next=4，
                 把当前节点的子节点的子节点指向当前节点
                 此时链表为1->2->3->4<->5，由于4与5互相指向，所以此处要断开4.next=null
                 此时链表为1->2->3->4<-5
                 返回节点5
       第三轮出栈，head为3，head.next为4，执行head.next.next=head也就是4.next=3，
                 此时链表为1->2->3<->4<-5，由于3与4互相指向，所以此处要断开3.next=null
                 此时链表为1->2->3<-4<-5
                 返回节点5
       第四轮出栈，head为2，head.next为3，执行head.next.next=head也就是3.next=2，
                 此时链表为1->2<->3<-4<-5，由于2与3互相指向，所以此处要断开2.next=null
                 此时链表为1->2<-3<-4<-5
                 返回节点5
       第五轮出栈，head为1，head.next为2，执行head.next.next=head也就是2.next=1，
                 此时链表为1<->2<-3<-4<-5，由于1与2互相指向，所以此处要断开1.next=null
                 此时链表为1<-2<-3<-4<-5
                 返回节点5
       出栈完成，最终头节点5->4->3-2->1
*/

public class Solution206 {
    // 递归做法
    public ListNode recursionReverseList(ListNode head) {
        // 递归是一个入栈和出栈的过程，中间不透明
        if (head == null || head.next == null) {
            return head;
        }
        // 递归进入下一个节点，将新节点指向最后一位（将所有元素都入栈）
        ListNode newHead = recursionReverseList(head.next);
        // 将本节点的下一个节点指向本节点，做反向操作
        head.next.next = head;
        // 断开互相指向的正向节点
        head.next = null;
        // 开始出栈
        return newHead;
    }

    // 迭代做法
    public ListNode iterateReverseList(ListNode head) {
        ListNode newNode = null;
        while (head != null) {
            // 保存下一个节点的值
            ListNode next = head.next;
            // 将当前节点指向前一个节点
            head.next = newNode;
            // 将当前节点作为前一个节点的值
            newNode = head;
            // 将当前节点移动到下一个节点
            head = next;
        }
        return newNode;
    }
}
