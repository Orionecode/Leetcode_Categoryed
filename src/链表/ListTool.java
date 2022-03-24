package 链表;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/14 17:16
 * @Filename ListTool
 */

public class ListTool {
    // 打印链表
    public static String printLinkedList(ListNode head) {
        if (head == null) {
            return "[]";
        } else if (head.next == null) {
            return "[" + head.val + "]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head.next != null) {
            sb.append(head.val);
            sb.append(",");
            head = head.next;
        }
        sb.append(head.val);
        sb.append(']');
        return sb.toString();
    }

    // 构造链表
    public static ListNode constructListNode(int[] numbers) {
        if (numbers == null || numbers.length == 0){
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode preNode = dummyNode;
        for (int number : numbers) {
            preNode.next = new ListNode(number);
            preNode = preNode.next;
        }
        return dummyNode.next;
    }
}
