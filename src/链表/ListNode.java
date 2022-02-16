package 链表;

/**
 * @Author YixiaoZeng
 * @Date 2022/2/8 16:20
 * @Filename ListNode
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
