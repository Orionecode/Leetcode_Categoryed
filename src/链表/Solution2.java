package 链表;

// 2. 两数相加

public class Solution2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode pre = new ListNode(0);
		ListNode cur = pre;
		int carry = 0, sum = 0;
		while (l1 != null || l2 != null || carry > 0) {
			sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
			carry = sum / 10;
			sum = sum % 10;
			cur.next = new ListNode(sum);
			l1 = l1 == null ? null : l1.next; //A：布尔表达式(真/假)，B：执行语句 ，C ：执行语句 最直观的： A ？ B ：C (如果A为真执行B否则执行C)
			l2 = l2 == null ? null : l2.next; //如果l2 == null为真执行 l2 = null 否则执行 l2 = l2.next
			cur = cur.next;
		}
		return pre.next;
	}
}
