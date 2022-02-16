package 链表;

// 876. 链表的中间结点
// 给定一个头结点为 head 的非空单链表，返回链表的中间结点。

// 方法1: 链表的缺点在于不能通过下标访问对应的元素。因此我们可以考虑对链表进行遍历，同时将遍历到的元素依次放入数组 A 中。如果我们遍历到了 N 个元素，那么链表以及数组的长度也为 N，对应的中间节点即为 A[N/2]。

// 方法2：单指针法
// 我们可以对方法一进行空间优化，省去数组 A。
// 我们可以对链表进行两次遍历。第一次遍历时，我们统计链表中的元素个数 N；第二次遍历时，我们遍历到第 N/2 个元素（链表的首节点为第 0 个元素）时，将该元素返回即可。

// 方法3：快慢指针法
// 我们可以继续优化方法二，用两个指针 slow 与 fast 一起遍历链表。slow 一次走一步，fast 一次走两步。那么当 fast 到达链表的末尾时，slow 必然位于中间。


public class Solution876 {
    public ListNode listMiddleNode(ListNode head){
        int n = 0;
        ListNode[] listNodes = new ListNode[100];
        while (head != null){
            listNodes[n++] = head;
            head = head.next;
            n++;
        }
        return listNodes[n / 2];
    }

    public ListNode singlePointerMiddleNode(ListNode head) {
        int n = 0;
        int k = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        cur = head;
        while (k < n / 2) {
            k++;
            cur = cur.next;
        }
        return cur;
    }

    public  ListNode FOSPointerMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}