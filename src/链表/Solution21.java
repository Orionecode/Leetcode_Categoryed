package 链表;

// 21. 合并两个有序链表
// 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

/**
 * @Author YixiaoZeng
 * @Date 2022/1/29 15:25
 * @Filename Solution21
 */

public class Solution21 {
	// 采用递归的方式解答·
	public ListNode mergeTwoListsRe(ListNode list1, ListNode list2) {
		if (list1 == null){
			return list2;
		} else if (list2 == null){
			return list1;
		} else if (list1.val < list2.val){
			list1.next = mergeTwoListsRe(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoListsRe(list1, list2.next);
			return list2;
		}
    }
    // 采用迭代的方式解答
}
