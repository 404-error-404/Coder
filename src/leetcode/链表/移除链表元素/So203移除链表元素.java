package leetcode.链表.移除链表元素;

import leetcode.ListNode;
import org.junit.jupiter.api.Test;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 小乐乐
 * @date 2022/3/9 13:40
 */
public class So203移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        while (null != head && head.val == val) {
            head = head.next;
        }
        if (null == head) {
            return null;
        }
        ListNode cur = head, n = cur.next;
        while (null != n) {
            while (n.val == val) {
                n = n.next;
                if (null == n) {
                    cur.next = null;
                    return head;
                }
            }
            cur.next = n;
            cur = cur.next;
            n = n.next;
        }
        return head;
    }

    @Test
    public void test() {
        ListNode head = ListNode.createList(new int[]{1,1});
        int val = 6;
        head = removeElements(head, val);
        while (null != head) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
