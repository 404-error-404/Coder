package leetcode.链表.反转链表;

import leetcode.ListNode;
import org.junit.jupiter.api.Test;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * @author 小乐乐
 * @date 2022/3/10 18:26
 */
public class So206反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode p = head, next;
        head = null;
        while (null != p) {
            next = p.next;
            p.next = head;
            head = p;
            p = next;
        }
        return head;
    }

    @Test
    public void test() {
        ListNode head = ListNode.createList(new int[]{});
        head = reverseList(head);
        System.out.println(head.toString());
    }
}
