package leetcode.链表.删除链表的倒数第N个节点;

import leetcode.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/10 18:48
 */
public class So19删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = new ListNode();
        slow.next = head;
        head = slow;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (null != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head.next;
    }
}
