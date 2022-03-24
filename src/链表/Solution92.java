package 链表;

// 92. 反转链表 II
// 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。

/**
 * @Author YixiaoZeng
 * @Date 2022/2/10 19:03
 * @Filename Solution92
 */

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode superior = dummyNode;

        // 1. 遍历至left的前一个节点
        for (int i = 1; i < left; i++) {
            superior = superior.next;
        }

        ListNode prev = null;
        ListNode cur = superior.next;

        // 2. 180°反转区间链表
        for (int i = 0; i <= right - left; i++) {
            ListNode next = cur.next;
            System.out.println(i);
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // 3. 修改left和right-left位置处的节点的指向
        superior.next.next = cur;
        superior.next = prev;
        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
        // cur 指针指向头节点
        ListNode cur = head;
        // pre 指针为空
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
    }

    public static void main(String[] args) {
        Solution92 solution92 = new Solution92();
        ListNode head = ListTool.constructListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(ListTool.printLinkedList(solution92.reverseBetween(head, 2, 4)));
    }
}
